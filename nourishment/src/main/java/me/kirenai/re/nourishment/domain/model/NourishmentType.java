package me.kirenai.re.nourishment.domain.model;

import lombok.Builder;
import me.kirenai.re.nourishment.util.enums.NourishmentTypeEnum;

@Builder
public record NourishmentType(
        Long nourishmentTypeId,
        NourishmentTypeEnum name
) {
}
