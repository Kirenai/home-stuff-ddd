package me.kirenai.re.role.domain.port.in;

import me.kirenai.re.role.domain.model.Role;
import reactor.core.publisher.Mono;

public interface GetRolePort {

    Mono<Role> getRoleById(Long roleId);

    Mono<Role> getRoleByName(String name);

}
