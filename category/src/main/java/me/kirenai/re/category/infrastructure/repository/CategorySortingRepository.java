package me.kirenai.re.category.infrastructure.repository;

import me.kirenai.re.category.infrastructure.entity.CategoryEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import reactor.core.publisher.Flux;

public interface CategorySortingRepository extends ReactiveSortingRepository<CategoryEntity, Long> {

    Flux<CategoryEntity> findAllBy(Pageable pageable);

}
