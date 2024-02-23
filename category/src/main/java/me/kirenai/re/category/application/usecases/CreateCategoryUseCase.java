package me.kirenai.re.category.application.usecases;

import lombok.RequiredArgsConstructor;
import me.kirenai.re.category.domain.model.Category;
import me.kirenai.re.category.domain.port.in.CreateCategoryPort;
import me.kirenai.re.category.domain.port.out.CategoryRepositoryPort;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CreateCategoryUseCase implements CreateCategoryPort {

    private final CategoryRepositoryPort categoryRepositoryPort;

    @Override
    public Mono<Category> createCategory(Category category) {
        return this.categoryRepositoryPort.createCategory(category);
    }

}
