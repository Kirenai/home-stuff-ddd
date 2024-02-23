package me.kirenai.re.category.infrastructure.repository;

import me.kirenai.re.category.infrastructure.entity.CategoryEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CategoryRepository extends ReactiveCrudRepository<CategoryEntity, Long> {
}