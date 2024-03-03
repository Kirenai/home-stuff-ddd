package me.kirenai.re.role.domain.port.out.repository;

import me.kirenai.re.role.domain.model.Role;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;

public interface RoleSortingRepositoryPort {

    Flux<Role> findAll(Pageable pageable);

}
