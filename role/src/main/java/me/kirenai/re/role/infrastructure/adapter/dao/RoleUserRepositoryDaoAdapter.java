package me.kirenai.re.role.infrastructure.adapter.dao;

import lombok.RequiredArgsConstructor;
import me.kirenai.re.role.domain.model.Role;
import me.kirenai.re.role.domain.model.RoleUser;
import me.kirenai.re.role.domain.port.out.dao.RoleUserRepositoryDaoPort;
import me.kirenai.re.role.infrastructure.entity.RoleUserEntity;
import me.kirenai.re.role.infrastructure.mapper.RoleMapper;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class RoleUserRepositoryDaoAdapter implements RoleUserRepositoryDaoPort {

    private final DatabaseClient client;
    private final RoleMapper mapper;

    @Override
    public Flux<Role> findByUserId(Long userId) {
        return this.client
                .sql("""
                        SELECT r.role_id r_roleId, r.name r_name
                        FROM roles r LEFT JOIN roles_users ru ON r.role_id = ru.role_id 
                        WHERE ru.user_id = :userId
                        """)
                .bind("userId", userId)
                .fetch()
                .all()
                .bufferUntilChanged(result -> result.get("r_roleId"))
                .flatMap(RoleUserEntity::fromRows)
                .flatMap(roleUserEntity -> Flux.fromIterable(roleUserEntity.getRoles()))
                .map(this.mapper::mapOutRoleEntityToRole);
    }

    @Override
    public Mono<Void> saveRoleUser(RoleUser roleUser) {
        return this.client
                .sql("INSERT INTO roles_users(role_id, user_id) VALUES(:roleId, :userId)")
                .bind("roleId", roleUser.getRoleId())
                .bind("userId", roleUser.getUserId())
                .fetch()
                .first()
                .then();
    }

}
