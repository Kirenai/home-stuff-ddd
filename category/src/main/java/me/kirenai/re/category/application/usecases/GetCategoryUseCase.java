package me.kirenai.re.category.application.usecases;

import lombok.RequiredArgsConstructor;
import me.kirenai.re.category.domain.model.Category;
import me.kirenai.re.category.domain.port.in.GetCategoryPort;
import me.kirenai.re.category.domain.port.out.CategoryRepositoryPort;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class GetCategoryUseCase implements GetCategoryPort {

    private final CategoryRepositoryPort categoryRepositoryPort;

    @Override
    public Mono<Category> getCategoryById(Long categoryId) {
        return this.categoryRepositoryPort.findById(categoryId);
    }

}
