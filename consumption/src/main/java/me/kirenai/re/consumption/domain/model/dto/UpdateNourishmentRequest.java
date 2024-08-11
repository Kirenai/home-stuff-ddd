package me.kirenai.re.consumption.domain.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public record UpdateNourishmentRequest(
        String name,
        String imageUrl,
        String description,
        UpdateNourishmentTypeRequest type
) {
}
