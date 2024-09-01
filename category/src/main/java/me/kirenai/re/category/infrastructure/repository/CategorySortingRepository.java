package me.kirenai.re.category.infrastructure.repository;

import me.kirenai.re.category.infrastructure.entity.CategoryEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface CategorySortingRepository extends ReactiveMongoRepository<CategoryEntity, String> {

    Flux<CategoryEntity> findAllBy(Pageable pageable);

}
