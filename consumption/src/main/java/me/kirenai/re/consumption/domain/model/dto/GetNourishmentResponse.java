package me.kirenai.re.consumption.domain.model.dto;

public record GetNourishmentResponse(
        String nourishmentId,
        String name,
        String imageUrl,
        String description,
        Boolean isAvailable,
        GetNourishmentTypeResponse type
) {
}
