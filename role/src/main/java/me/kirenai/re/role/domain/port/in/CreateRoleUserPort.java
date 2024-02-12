package me.kirenai.re.role.domain.port.in;

import me.kirenai.re.role.domain.model.Role;
import reactor.core.publisher.Mono;

public interface CreateRoleUserPort {

    Mono<Void> createRoleUser(Long userId, Role role);

}
