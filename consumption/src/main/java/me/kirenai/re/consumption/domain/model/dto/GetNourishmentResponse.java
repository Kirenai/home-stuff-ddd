package me.kirenai.re.consumption.domain.model.dto;

public record GetNourishmentResponse(
        Long nourishmentId,
        GetNourishmentTypeResponse type
) {
}
