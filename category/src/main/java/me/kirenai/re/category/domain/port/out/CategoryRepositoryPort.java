package me.kirenai.re.category.domain.port.out;

import me.kirenai.re.category.domain.model.Category;
import reactor.core.publisher.Mono;

public interface CategoryRepositoryPort {

    Mono<Category> findById(String categoryId);

    Mono<Category> createCategory(Category category);

    Mono<Category> updateCategory(String categoryId, Category category);

    Mono<Void> deleteCategory(String categoryId);


}
