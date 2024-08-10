package me.kirenai.re.nourishment.domain.model.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import me.kirenai.re.nourishment.domain.enums.NourishmentTypeEnum;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(as = UpdateNourishmentTypePercentageRequest.class)
public record UpdateNourishmentTypePercentageRequest(
        @NotNull
        NourishmentTypeEnum nourishmentType,
        @NotNull
        @Max(value = 100)
        @Min(value = 0)
        Integer percentage
) implements UpdateNourishmentTypeRequest {

    @JsonCreator
    public UpdateNourishmentTypePercentageRequest(@JsonProperty("nourishmentType") NourishmentTypeEnum nourishmentType,
                                                  @JsonProperty("percentage") Integer percentage) {
        this.nourishmentType = NourishmentTypeEnum.PERCENTAGE;
        this.percentage = percentage;
    }

}
