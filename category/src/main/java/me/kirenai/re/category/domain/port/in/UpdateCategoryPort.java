package me.kirenai.re.category.domain.port.in;

import me.kirenai.re.category.domain.model.Category;
import reactor.core.publisher.Mono;

public interface UpdateCategoryPort {

    Mono<Category> updateCategory(String categoryId, Category category);

}
