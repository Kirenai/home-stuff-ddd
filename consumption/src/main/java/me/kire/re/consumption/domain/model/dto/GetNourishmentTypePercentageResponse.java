package me.kire.re.consumption.domain.model.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import me.kire.re.consumption.util.enums.NourishmentTypeEnum;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(as = GetNourishmentTypePercentageResponse.class)
public record GetNourishmentTypePercentageResponse(
        NourishmentTypeEnum nourishmentType,
        Integer percentage
) implements GetNourishmentTypeResponse {

    @JsonCreator
    public GetNourishmentTypePercentageResponse(@JsonProperty("nourishmentType") NourishmentTypeEnum nourishmentType,
                                                @JsonProperty("percentage") Integer percentage) {
        this.nourishmentType = NourishmentTypeEnum.PERCENTAGE;
        this.percentage = percentage;
    }

}
