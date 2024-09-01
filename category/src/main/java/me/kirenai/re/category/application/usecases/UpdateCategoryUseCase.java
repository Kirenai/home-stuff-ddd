package me.kirenai.re.category.application.usecases;

import lombok.RequiredArgsConstructor;
import me.kirenai.re.category.domain.model.Category;
import me.kirenai.re.category.domain.port.in.UpdateCategoryPort;
import me.kirenai.re.category.domain.port.out.CategoryRepositoryPort;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class UpdateCategoryUseCase implements UpdateCategoryPort {

    private final CategoryRepositoryPort categoryRepositoryPort;

    @Override
    public Mono<Category> updateCategory(String categoryId, Category category) {
        return this.categoryRepositoryPort.updateCategory(categoryId, category);
    }

}
