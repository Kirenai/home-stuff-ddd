package me.kirenai.re.category.domain.model.dto;

import lombok.Builder;

@Builder
public record CreateCategoryResponse(
        Long categoryId,
        String name
) {
}
