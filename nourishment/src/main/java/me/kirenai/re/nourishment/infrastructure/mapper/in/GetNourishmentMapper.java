package me.kirenai.re.nourishment.infrastructure.mapper.in;

import me.kirenai.re.nourishment.domain.model.Nourishment;
import me.kirenai.re.nourishment.domain.model.NourishmentType;
import me.kirenai.re.nourishment.domain.model.NourishmentTypePercentage;
import me.kirenai.re.nourishment.domain.model.NourishmentTypeUnit;
import me.kirenai.re.nourishment.domain.model.dto.GetNourishmentResponse;
import me.kirenai.re.nourishment.domain.model.dto.GetNourishmentTypePercentageResponse;
import me.kirenai.re.nourishment.domain.model.dto.GetNourishmentTypeResponse;
import me.kirenai.re.nourishment.domain.model.dto.GetNourishmentTypeUnitResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface GetNourishmentMapper {

    // Map Out to GetResponse
    @Mapping(target = "type", source = "nourishmentType", qualifiedByName = "mapOutGetNourishmentTypeResponse")
    GetNourishmentResponse mapOutNourishmentToGetNourishmentResponse(Nourishment nourishment);

    @Named("mapOutGetNourishmentTypeResponse")
    default GetNourishmentTypeResponse mapOutGetNourishmentTypeResponse(NourishmentType nourishmentType) {
        return switch (nourishmentType) {
            case NourishmentTypePercentage percentage -> this.mapOutGetNourishmentTypePercentageResponse(percentage);
            case NourishmentTypeUnit unit -> this.mapOutGetNourishmentTypeUnitResponse(unit);
        };
    }

    GetNourishmentTypePercentageResponse mapOutGetNourishmentTypePercentageResponse(NourishmentTypePercentage nourishmentTypePercentage);

    GetNourishmentTypeUnitResponse mapOutGetNourishmentTypeUnitResponse(NourishmentTypeUnit nourishmentTypeUnit);
    // End GetResponse
}
