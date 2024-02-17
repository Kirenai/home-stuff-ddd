package me.kirenai.re.nourishment.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import me.kirenai.re.nourishment.domain.model.Nourishment;
import me.kirenai.re.nourishment.infrastructure.entity.NourishmentEntity;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MapperUtils {

    public static NourishmentEntity loadNourishmentToNourishmentEntityByReference(Nourishment nourishment, NourishmentEntity nourishmentEntity) {
        nourishmentEntity.setName(nourishment.getName());
        nourishmentEntity.setDescription(nourishment.getDescription());
        nourishmentEntity.setImageUrl(nourishment.getImageUrl());
        nourishmentEntity.setUnit(nourishment.getUnit());
        nourishmentEntity.setPercentage(nourishment.getPercentage());
        return nourishmentEntity;
    }

}
