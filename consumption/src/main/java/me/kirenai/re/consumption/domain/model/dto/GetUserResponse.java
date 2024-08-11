package me.kirenai.re.consumption.domain.model.dto;

import lombok.Builder;

@Builder
public record GetUserResponse(
        String userId
) {
}
