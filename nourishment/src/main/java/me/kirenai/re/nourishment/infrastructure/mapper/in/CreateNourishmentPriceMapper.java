package me.kirenai.re.nourishment.infrastructure.mapper.in;

import me.kirenai.re.nourishment.domain.model.NourishmentPrice;
import me.kirenai.re.nourishment.domain.model.dto.price.CreateNourishmentPriceRequest;
import me.kirenai.re.nourishment.domain.model.dto.price.CreateNourishmentPriceResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CreateNourishmentPriceMapper {
    NourishmentPrice mapInNourishmentPrice(String nourishmentId, CreateNourishmentPriceRequest createNourishmentPriceRequest);

    CreateNourishmentPriceResponse mapOutCreateNourishmentPriceResponse(NourishmentPrice nourishmentPrice);
}
