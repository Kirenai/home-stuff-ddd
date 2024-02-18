package me.kirenai.re.nourishment.infrastructure.mapper.impl;

import lombok.Setter;
import me.kirenai.re.nourishment.domain.model.Nourishment;
import me.kirenai.re.nourishment.domain.model.dto.*;
import me.kirenai.re.nourishment.domain.port.out.repository.NourishmentTypeRepositoryPort;
import me.kirenai.re.nourishment.infrastructure.mapper.NourishmentMapper;
import me.kirenai.re.nourishment.util.enums.NourishmentTypeEnum;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Setter(onMethod = @__(@Autowired))
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, config = NourishmentMapper.class)
public abstract class AbstractNourishmentMapper implements NourishmentMapper {

    private NourishmentTypeRepositoryPort nourishmentTypeRepositoryPort;


    @Override
    public Mono<Nourishment> mapInCreateNourishmentRequestToNourishment(CreateNourishmentRequest createNourishmentRequest) {
        if (Objects.isNull(createNourishmentRequest)) {
            return null;
        }

        Nourishment nourishment = this.mapInNourishment(createNourishmentRequest);

        return switch (createNourishmentRequest.type()) {
            case CreateNourishmentTypeUnitRequest unit -> {
                nourishment.setUnit(unit.unit());
                yield this.nourishmentTypeRepositoryPort.findByName(unit.nourishmentType().getName())
                        .map(nourishmentType -> {
                            nourishment.setNourishmentTypeId(nourishmentType.nourishmentTypeId());
                            return nourishment;
                        });
            }
            case CreateNourishmentTypePercentageRequest percentage -> {
                nourishment.setPercentage(percentage.percentage());
                yield this.nourishmentTypeRepositoryPort.findByName(percentage.nourishmentType().getName())
                        .map(nourishmentType -> {
                            nourishment.setNourishmentTypeId(nourishmentType.nourishmentTypeId());
                            return nourishment;
                        });
            }
        };
    }

    @Override
    public Mono<Nourishment> mapInUpdateNourishmentRequestToNourishment(UpdateNourishmentRequest updateNourishmentRequest) {
        if (Objects.isNull(updateNourishmentRequest)) {
            return null;
        }

        Nourishment nourishment = this.mapInNourishment(updateNourishmentRequest);

        return switch (updateNourishmentRequest.type()) {
            case CreateNourishmentTypeUnitRequest unit -> {
                nourishment.setUnit(unit.unit());
                yield this.nourishmentTypeRepositoryPort.findByName(unit.nourishmentType().getName())
                        .map(nourishmentType -> {
                            nourishment.setNourishmentTypeId(nourishmentType.nourishmentTypeId());
                            return nourishment;
                        });
            }
            case CreateNourishmentTypePercentageRequest percentage -> {
                nourishment.setPercentage(percentage.percentage());
                yield this.nourishmentTypeRepositoryPort.findByName(percentage.nourishmentType().getName())
                        .map(nourishmentType -> {
                            nourishment.setNourishmentTypeId(nourishmentType.nourishmentTypeId());
                            return nourishment;
                        });
            }
        };
    }

    @Override
    public Mono<ListNourishmentsResponse> mapOutNourishmentToListNourishmentsResponse(Nourishment nourishment) {
        if (Objects.isNull(nourishment)) {
            return null;
        }

        ListNourishmentsResponse listNourishmentsResponse = this.mapOutListNourishmentsResponse(nourishment);

        return this.nourishmentTypeRepositoryPort.findById(nourishment.getNourishmentTypeId())
                .map(nourishmentTypeEntity -> {
                    switch (nourishmentTypeEntity.name()) {
                        case UNIT -> listNourishmentsResponse.setType(
                                this.mapOutListNourishmentsTypeUnitResponse(
                                        nourishment,
                                        nourishmentTypeEntity.name()
                                ));
                        case PERCENTAGE -> listNourishmentsResponse.setType(
                                this.mapOutListNourishmentsTypePercentageResponse(
                                        nourishment,
                                        nourishmentTypeEntity.name()
                                ));
                    }
                    return listNourishmentsResponse;
                });
    }

    @Mapping(target = "nourishmentType", source = "type")
    @Mapping(target = "unit", source = "nourishment.unit")
    abstract ListNourishmentsTypeUnitResponse mapOutListNourishmentsTypeUnitResponse(Nourishment nourishment, NourishmentTypeEnum type);

    @Mapping(target = "nourishmentType", source = "type")
    @Mapping(target = "percentage", source = "nourishment.percentage")
    abstract ListNourishmentsTypePercentageResponse mapOutListNourishmentsTypePercentageResponse(Nourishment nourishment, NourishmentTypeEnum type);

}
