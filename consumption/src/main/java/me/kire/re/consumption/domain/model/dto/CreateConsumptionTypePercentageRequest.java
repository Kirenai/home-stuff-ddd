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
@JsonDeserialize(as = CreateConsumptionTypePercentageRequest.class)
public record CreateConsumptionTypePercentageRequest(
        @NotNull
        ConsumptionTypeEnum consumptionType,
        @NotNull
        Integer percentage
) implements CreateConsumptionTypeRequest {

    @JsonCreator
    public CreateConsumptionTypePercentageRequest(@JsonProperty("consumptionType") ConsumptionTypeEnum consumptionType,
                                                  @JsonProperty("percentage") Integer percentage) {
        this.consumptionType = ConsumptionTypeEnum.PERCENTAGE;
        this.percentage = percentage;
    }

}
