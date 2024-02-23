package me.kirenai.re.category.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import me.kirenai.re.category.domain.model.Category;
import me.kirenai.re.category.infrastructure.entity.CategoryEntity;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MapperUtils {

    public static CategoryEntity loadCategoryToCategoryEntityByReference(Category category, CategoryEntity categoryEntity) {
        categoryEntity.setName(category.getName());
        return categoryEntity;
    }

}
