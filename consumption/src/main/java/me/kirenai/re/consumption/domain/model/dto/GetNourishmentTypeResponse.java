package me.kirenai.re.consumption.domain.model.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "nourishmentType")
@JsonSubTypes({
        @Type(value = GetNourishmentTypeUnitResponse.class, name = "UNIT"),
        @Type(value = GetNourishmentTypePercentageResponse.class, name = "PERCENTAGE")
})
public sealed interface GetNourishmentTypeResponse
        permits GetNourishmentTypeUnitResponse, GetNourishmentTypePercentageResponse {
}
