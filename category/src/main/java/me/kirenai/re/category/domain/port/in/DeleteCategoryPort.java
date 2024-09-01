package me.kirenai.re.category.domain.port.in;

import reactor.core.publisher.Mono;

public interface DeleteCategoryPort {

    Mono<Void> deleteCategory(String categoryId);

}
