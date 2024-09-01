package me.kirenai.re.category.infrastructure.repository;

import me.kirenai.re.category.infrastructure.entity.CategoryEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CategoryRepository extends ReactiveMongoRepository<CategoryEntity, String> {
}