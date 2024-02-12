package me.kirenai.re.role.infrastructure.repository;

import me.kirenai.re.role.infrastructure.entity.RoleEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface RoleRepository extends ReactiveCrudRepository<RoleEntity, Long> {

    Mono<RoleEntity> findByName(String name);

}