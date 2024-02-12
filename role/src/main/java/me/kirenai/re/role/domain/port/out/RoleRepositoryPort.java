package me.kirenai.re.role.domain.port.out;

import me.kirenai.re.role.domain.model.Role;
import reactor.core.publisher.Mono;

public interface RoleRepositoryPort {

    Mono<Role> findById(Long roleId);

    Mono<Role> findByName(String name);

    Mono<Role> createRole(Role role);

    Mono<Role> updateRole(Long roleId, Role role);

}
