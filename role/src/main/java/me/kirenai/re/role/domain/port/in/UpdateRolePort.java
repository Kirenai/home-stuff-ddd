package me.kirenai.re.role.domain.port.in;

import me.kirenai.re.role.domain.model.Role;
import reactor.core.publisher.Mono;

public interface UpdateRolePort {

    Mono<Role> updateRole(Long roleId, Role role);

}
