package me.kirenai.re.nourishment.infrastructure.mapper;

import me.kirenai.re.nourishment.domain.model.NourishmentType;
import me.kirenai.re.nourishment.infrastructure.entity.NourishmentTypeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface NourishmentTypeMapper {

    NourishmentType mapOutNourishmentTypeToNourishment(NourishmentTypeEntity nourishmentTypeEntity);

}
