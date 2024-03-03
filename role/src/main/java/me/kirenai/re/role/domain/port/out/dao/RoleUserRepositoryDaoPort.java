package me.kirenai.re.role.domain.port.out.dao;

import me.kirenai.re.role.domain.model.Role;
import me.kirenai.re.role.domain.model.RoleUser;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RoleUserRepositoryDaoPort {

    Flux<Role> findByUserId(Long userId);

    Mono<Void> saveRoleUser(RoleUser roleUser);

}