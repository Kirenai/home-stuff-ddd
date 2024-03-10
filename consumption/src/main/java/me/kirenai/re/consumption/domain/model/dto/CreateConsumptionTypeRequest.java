package me.kirenai.re.consumption.domain.model.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "consumptionType")
@JsonSubTypes({
        @Type(value = CreateConsumptionTypeUnitRequest.class, name = "UNIT"),
        @Type(value = CreateConsumptionTypePercentageRequest.class, name = "PERCENTAGE")
})
public sealed interface CreateConsumptionTypeRequest
        permits CreateConsumptionTypeUnitRequest, CreateConsumptionTypePercentageRequest {
}
