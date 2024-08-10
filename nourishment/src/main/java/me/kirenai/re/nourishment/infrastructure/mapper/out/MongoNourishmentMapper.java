package me.kirenai.re.nourishment.infrastructure.mapper.out;

import me.kirenai.re.nourishment.domain.model.Nourishment;
import me.kirenai.re.nourishment.infrastructure.entity.NourishmentDocument;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MongoNourishmentMapper {
    // Map In to Document
    NourishmentDocument mapInNourishmentToNourishmentEntity(Nourishment nourishment);
    // End Document

    // Map Out to Domain
    Nourishment mapOutNourishmentEntityToNourishment(NourishmentDocument nourishmentDocument);
    // End Domain
}
