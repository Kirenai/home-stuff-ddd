package me.kirenai.re.category.domain.port.in;

import me.kirenai.re.category.domain.model.Category;
import reactor.core.publisher.Mono;

public interface CreateCategoryPort {

    Mono<Category> createCategory(Category category);

}
