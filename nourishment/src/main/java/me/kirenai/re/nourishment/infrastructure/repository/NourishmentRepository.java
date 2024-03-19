package me.kirenai.re.nourishment.infrastructure.repository;

import me.kirenai.re.nourishment.infrastructure.entity.NourishmentEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface NourishmentRepository extends ReactiveCrudRepository<NourishmentEntity, Long> {
}