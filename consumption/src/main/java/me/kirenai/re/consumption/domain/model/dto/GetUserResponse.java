package me.kirenai.re.consumption.domain.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record GetUserResponse(
        @JsonProperty("userId")
        String userId
) {
}
