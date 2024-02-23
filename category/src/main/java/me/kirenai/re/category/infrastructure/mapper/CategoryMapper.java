package me.kirenai.re.category.infrastructure.mapper;

import me.kirenai.re.category.domain.model.Category;
import me.kirenai.re.category.domain.model.dto.*;
import me.kirenai.re.category.infrastructure.entity.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CategoryMapper {

    //Map In
    CategoryEntity mapInCategoryToCategoryEntity(Category category);

    Category mapInCreateCategoryRequestToCategory(CreateCategoryRequest categoryRequest);

    Category mapInUpdateCategoryRequestToCategory(UpdateCategoryRequest updateCategoryRequest);

    //Map Out
    Category mapOutCategoryEntityToCategory(CategoryEntity categoryEntity);

    GetCategoryResponse mapOutCategoryToGetCategoryResponse(Category category);

    ListCategoriesResponse mapOutCategoryToListCategoriesResponse(Category category);

    CreateCategoryResponse mapOutCategoryToCreateCategoryResponse(Category category);

    UpdateCategoryResponse mapOutCategoryToUpdateCategoryResponse(Category category);

}
