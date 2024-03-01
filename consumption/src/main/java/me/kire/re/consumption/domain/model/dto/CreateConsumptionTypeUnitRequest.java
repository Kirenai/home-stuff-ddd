package me.kire.re.consumption.domain.model.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import me.kire.re.consumption.util.enums.ConsumptionTypeEnum;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(as = CreateConsumptionTypeUnitRequest.class)
public record CreateConsumptionTypeUnitRequest(
        @NotNull
        ConsumptionTypeEnum consumptionType,
        @NotNull
        Integer unit
) implements CreateConsumptionTypeRequest {

    @JsonCreator
    public CreateConsumptionTypeUnitRequest(@JsonProperty("consumptionType") ConsumptionTypeEnum consumptionType,
                                            @JsonProperty("unit") Integer unit) {
        this.consumptionType = ConsumptionTypeEnum.UNIT;
        this.unit = unit;
    }

}
