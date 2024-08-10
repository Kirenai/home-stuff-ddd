package me.kirenai.re.nourishment.domain.model;

public sealed interface NourishmentType
        permits NourishmentTypeUnit, NourishmentTypePercentage {
}
