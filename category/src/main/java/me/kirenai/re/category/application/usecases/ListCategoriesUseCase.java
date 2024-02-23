package me.kirenai.re.category.application.usecases;

import lombok.RequiredArgsConstructor;
import me.kirenai.re.category.domain.model.Category;
import me.kirenai.re.category.domain.port.in.ListCategoriesPort;
import me.kirenai.re.category.domain.port.out.CategorySortingRepositoryPort;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class ListCategoriesUseCase implements ListCategoriesPort {

    private final CategorySortingRepositoryPort categorySortingRepositoryPort;

    @Override
    public Flux<Category> findAll(Pageable pageable) {
        return this.categorySortingRepositoryPort.findAll(pageable);
    }

}
