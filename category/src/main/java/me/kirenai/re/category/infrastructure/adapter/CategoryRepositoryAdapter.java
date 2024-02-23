package me.kirenai.re.category.infrastructure.adapter;

import lombok.RequiredArgsConstructor;
import me.kirenai.re.category.domain.model.Category;
import me.kirenai.re.category.domain.port.out.CategoryRepositoryPort;
import me.kirenai.re.category.infrastructure.mapper.CategoryMapper;
import me.kirenai.re.category.infrastructure.repository.CategoryRepository;
import me.kirenai.re.category.util.MapperUtils;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class CategoryRepositoryAdapter implements CategoryRepositoryPort {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper mapper;

    @Override
    public Mono<Category> findById(Long categoryId) {
        return this.categoryRepository.findById(categoryId)
                .map(this.mapper::mapOutCategoryEntityToCategory);
    }

    @Override
    public Mono<Category> createCategory(Category category) {
        return Mono.just(this.mapper.mapInCategoryToCategoryEntity(category))
                .flatMap(this.categoryRepository::save)
                .map(this.mapper::mapOutCategoryEntityToCategory);
    }

    @Override
    public Mono<Category> updateCategory(Long categoryId, Category category) {
        return this.categoryRepository.findById(categoryId)
                .map(categoryEntity -> MapperUtils.loadCategoryToCategoryEntityByReference(category, categoryEntity))
                .flatMap(this.categoryRepository::save)
                .map(this.mapper::mapOutCategoryEntityToCategory);
    }

    public Mono<Void> deleteCategory(Long categoryId) {
        return this.categoryRepository.findById(categoryId)
                .flatMap(this.categoryRepository::delete);
    }

}
