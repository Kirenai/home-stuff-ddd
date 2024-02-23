package me.kirenai.re.category.domain.model.dto;

import lombok.Builder;

@Builder
public record CreateCategoryRequest(
        String name
) {
}
