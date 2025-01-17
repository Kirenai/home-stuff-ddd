package me.kirenai.re.consumption.domain.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ListConsumptionsResponse(
        String consumptionId,
        Integer unit,
        Integer percentage
) {
}
