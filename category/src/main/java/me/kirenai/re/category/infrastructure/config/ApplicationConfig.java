package me.kirenai.re.category.infrastructure.config;

import me.kirenai.re.category.application.service.CategoryService;
import me.kirenai.re.category.application.usecases.*;
import me.kirenai.re.category.domain.port.out.CategoryRepositoryPort;
import me.kirenai.re.category.domain.port.out.CategorySortingRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public CategoryService categoryService(CategoryRepositoryPort categoryRepositoryPort,
                                           CategorySortingRepositoryPort categorySortingRepositoryPort) {
        return new CategoryService(
                new GetCategoryUseCase(categoryRepositoryPort),
                new ListCategoriesUseCase(categorySortingRepositoryPort),
                new CreateCategoryUseCase(categoryRepositoryPort),
                new UpdateCategoryUseCase(categoryRepositoryPort),
                new DeleteCategoryUseCase(categoryRepositoryPort)
        );
    }

}
