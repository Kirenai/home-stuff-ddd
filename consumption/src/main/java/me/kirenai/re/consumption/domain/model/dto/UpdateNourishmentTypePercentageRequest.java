package me.kirenai.re.consumption.domain.model.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import me.kirenai.re.consumption.domain.enums.NourishmentTypeEnum;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(as = UpdateNourishmentTypePercentageRequest.class)
public record UpdateNourishmentTypePercentageRequest(
        NourishmentTypeEnum nourishmentType,
        Integer percentage
) implements UpdateNourishmentTypeRequest {

    @JsonCreator
    public UpdateNourishmentTypePercentageRequest(@JsonProperty("nourishmentType") NourishmentTypeEnum nourishmentType,
                                                  @JsonProperty("percentage") Integer percentage) {
        this.nourishmentType = NourishmentTypeEnum.PERCENTAGE;
        this.percentage = percentage;
    }

}
