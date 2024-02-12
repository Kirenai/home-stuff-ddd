package me.kirenai.re.role.domain.port.out;

import me.kirenai.re.role.domain.model.Role;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RoleUserRepositoryDaoPort {

    Flux<Role> findByUserId(Long userId);

    Mono<Void> saveRoleUser(Long roleId, Role role);

}