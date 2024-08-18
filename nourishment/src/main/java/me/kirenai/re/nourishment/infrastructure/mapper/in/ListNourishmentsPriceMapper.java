package me.kirenai.re.nourishment.infrastructure.mapper.in;

import me.kirenai.re.nourishment.domain.model.NourishmentPrice;
import me.kirenai.re.nourishment.domain.model.dto.price.ListNourishmentsPriceResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ListNourishmentsPriceMapper {
    ListNourishmentsPriceResponse mapOutListNourishmentsPriceResponse(NourishmentPrice nourishmentPrice);
}
