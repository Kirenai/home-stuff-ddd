package me.kire.re.consumption.domain.model.dto;

public record GetNourishmentResponse(
        Long nourishmentId,
        GetNourishmentTypeResponse type
) {
}
