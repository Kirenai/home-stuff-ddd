package me.kirenai.re.consumption.domain.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ConsumptionErrorMessageResponse(
        Integer statusCode,
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        LocalDateTime timestamp,
        String path,
        String message
) {
}
