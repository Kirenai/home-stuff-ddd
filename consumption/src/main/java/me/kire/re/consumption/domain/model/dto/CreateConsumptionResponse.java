package me.kire.re.consumption.domain.model.dto;

import lombok.Builder;

@Builder
public record CreateConsumptionResponse(
        Long consumptionId,
        Integer unit,
        Integer percentage
) {
}
