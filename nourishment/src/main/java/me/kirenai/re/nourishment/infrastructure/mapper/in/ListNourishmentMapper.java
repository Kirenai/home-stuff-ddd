package me.kirenai.re.nourishment.infrastructure.mapper.in;

import me.kirenai.re.nourishment.domain.model.Nourishment;
import me.kirenai.re.nourishment.domain.model.NourishmentType;
import me.kirenai.re.nourishment.domain.model.NourishmentTypePercentage;
import me.kirenai.re.nourishment.domain.model.NourishmentTypeUnit;
import me.kirenai.re.nourishment.domain.model.dto.ListNourishmentsResponse;
import me.kirenai.re.nourishment.domain.model.dto.ListNourishmentsTypePercentageResponse;
import me.kirenai.re.nourishment.domain.model.dto.ListNourishmentsTypeResponse;
import me.kirenai.re.nourishment.domain.model.dto.ListNourishmentsTypeUnitResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ListNourishmentMapper {

    // Map Out to ListResponse
    @Mapping(target = "type", source = "nourishmentType", qualifiedByName = "mapOutListNourishmentsTypeResponse")
    ListNourishmentsResponse mapOutNourishmentToListNourishmentsResponse(Nourishment nourishment);

    @Named("mapOutListNourishmentsTypeResponse")
    default ListNourishmentsTypeResponse mapOutListNourishmentsTypeResponse(NourishmentType nourishmentType) {
        return switch (nourishmentType) {
            case NourishmentTypePercentage percentage -> this.mapOutListNourishmentsTypePercentageResponse(percentage);
            case NourishmentTypeUnit unit -> this.mapOutListNourishmentsTypeUnitResponse(unit);
        };
    }

    ListNourishmentsTypePercentageResponse mapOutListNourishmentsTypePercentageResponse(NourishmentTypePercentage nourishmentTypePercentage);

    ListNourishmentsTypeUnitResponse mapOutListNourishmentsTypeUnitResponse(NourishmentTypeUnit nourishmentTypeUnit);
    // End ListResponse
}
