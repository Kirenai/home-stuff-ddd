package me.kirenai.re.role.domain.port.in;

import me.kirenai.re.role.domain.model.RoleUser;
import reactor.core.publisher.Mono;

public interface CreateRoleUserPort {

    Mono<Void> createRoleUser(RoleUser roleUser);

}
