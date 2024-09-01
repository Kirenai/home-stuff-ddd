package me.kirenai.re.category.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.kirenai.re.category.domain.model.Category;
import me.kirenai.re.category.domain.port.in.*;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
public class CategoryService {

    private final GetCategoryPort getCategoryPort;
    private final ListCategoriesPort listCategoriesPort;
    private final CreateCategoryPort createCategoryPort;
    private final UpdateCategoryPort updateCategoryPort;
    private final DeleteCategoryPort deleteCategoryPort;

    public Flux<Category> getCategories(Pageable pageable) {
        log.info("Invoking CategoryService.findAll method");
        return this.listCategoriesPort.findAll(pageable);
    }

    public Mono<Category> getCategoryById(String categoryId) {
        log.info("Invoking CategoryService.getCategoryById method");
        return this.getCategoryPort.getCategoryById(categoryId);
    }

    public Mono<Category> createCategory(Category category) {
        log.info("Invoking CategoryService.createCategory method");
        return this.createCategoryPort.createCategory(category);
    }

    public Mono<Category> updateCategory(String categoryId, Category category) {
        log.info("Invoking CategoryService.updateCategory method");
        return this.updateCategoryPort.updateCategory(categoryId, category);
    }

    public Mono<Void> deleteCategory(String categoryId) {
        log.info("Invoking CategoryService.deleteCategory method");
        return this.deleteCategoryPort.deleteCategory(categoryId);
    }

}