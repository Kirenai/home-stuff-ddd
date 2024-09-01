package me.kirenai.re.category.infrastructure.adapter;

import lombok.RequiredArgsConstructor;
import me.kirenai.re.category.domain.exception.CategoryNotFoundException;
import me.kirenai.re.category.domain.model.Category;
import me.kirenai.re.category.domain.port.out.CategoryRepositoryPort;
import me.kirenai.re.category.infrastructure.mapper.CategoryMapper;
import me.kirenai.re.category.infrastructure.repository.CategoryRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class CategoryRepositoryAdapter implements CategoryRepositoryPort {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper mapper;

    @Override
    public Mono<Category> findById(String categoryId) {
        return this.categoryRepository.findById(categoryId)
                .switchIfEmpty(Mono.error(new CategoryNotFoundException(String.format("Category not found with id: %s", categoryId))))
                .map(this.mapper::mapOutCategoryEntityToCategory);
    }

    @Override
    public Mono<Category> createCategory(Category category) {
        return Mono.just(this.mapper.mapInCategoryToCategoryEntity(category))
                .flatMap(this.categoryRepository::save)
                .map(this.mapper::mapOutCategoryEntityToCategory);
    }

    @Override
    public Mono<Category> updateCategory(String categoryId, Category category) {
        return this.categoryRepository.findById(categoryId)
                .map(categoryEntity -> {
                    categoryEntity.setName(category.getName());
                    return categoryEntity;
                })
                .flatMap(this.categoryRepository::save)
                .map(this.mapper::mapOutCategoryEntityToCategory);
    }

    public Mono<Void> deleteCategory(String categoryId) {
        return this.categoryRepository.findById(categoryId)
                .flatMap(this.categoryRepository::delete);
    }

}
