package me.kirenai.re.category.infrastructure.adapter;

import lombok.RequiredArgsConstructor;
import me.kirenai.re.category.domain.model.Category;
import me.kirenai.re.category.domain.port.out.CategorySortingRepositoryPort;
import me.kirenai.re.category.infrastructure.mapper.CategoryMapper;
import me.kirenai.re.category.infrastructure.repository.CategorySortingRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
@RequiredArgsConstructor
public class CategorySortingRepositoryAdapter implements CategorySortingRepositoryPort {

    private final CategorySortingRepository categorySortingRepository;
    private final CategoryMapper mapper;

    @Override
    public Flux<Category> findAll(Pageable pageable) {
        return this.categorySortingRepository.findAllBy(pageable)
                .map(this.mapper::mapOutCategoryEntityToCategory);
    }

}
