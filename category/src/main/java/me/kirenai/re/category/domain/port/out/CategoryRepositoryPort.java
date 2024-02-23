package me.kirenai.re.category.domain.port.out;

import me.kirenai.re.category.domain.model.Category;
import reactor.core.publisher.Mono;

public interface CategoryRepositoryPort {

    Mono<Category> findById(Long categoryId);

    Mono<Category> createCategory(Category category);

    Mono<Category> updateCategory(Long categoryId, Category category);

    Mono<Void> deleteCategory(Long categoryId);


}
