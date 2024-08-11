package me.kirenai.re.consumption.domain.model.dto;

import lombok.Builder;

@Builder
public record CreateConsumptionResponse(
        String consumptionId,
        Integer unit,
        Integer percentage
) {
}
