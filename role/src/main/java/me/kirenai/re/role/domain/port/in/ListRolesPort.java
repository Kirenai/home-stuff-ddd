package me.kirenai.re.role.domain.port.in;

import me.kirenai.re.role.domain.model.Role;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;

public interface ListRolesPort {

    Flux<Role> getRoles(Pageable pageable);

    Flux<Role> getRolesByUserId(Long userId);

}
