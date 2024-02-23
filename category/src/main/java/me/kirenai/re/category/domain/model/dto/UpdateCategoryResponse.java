package me.kirenai.re.category.domain.model.dto;

import lombok.Builder;

@Builder
public record UpdateCategoryResponse(
        Long categoryId,
        String name
) {
}
