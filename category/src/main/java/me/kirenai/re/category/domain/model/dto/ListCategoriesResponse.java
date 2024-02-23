package me.kirenai.re.category.domain.model.dto;

import lombok.Builder;

@Builder
public record ListCategoriesResponse(
        Long categoryId,
        String name
) {
}
