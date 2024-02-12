package me.kirenai.re.role.infrastructure.repository;

import me.kirenai.re.role.infrastructure.entity.RoleEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import reactor.core.publisher.Flux;

public interface RoleSortingRepository extends ReactiveSortingRepository<RoleEntity, Long> {

    Flux<RoleEntity> findAllBy(Pageable pageable);

}
