package me.kirenai.re.category.application.usecases;

import lombok.RequiredArgsConstructor;
import me.kirenai.re.category.domain.port.in.DeleteCategoryPort;
import me.kirenai.re.category.domain.port.out.CategoryRepositoryPort;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class DeleteCategoryUseCase implements DeleteCategoryPort {

    private final CategoryRepositoryPort categoryRepositoryPort;

    @Override
    public Mono<Void> deleteCategory(Long categoryId) {
        return this.categoryRepositoryPort.deleteCategory(categoryId);
    }

}
