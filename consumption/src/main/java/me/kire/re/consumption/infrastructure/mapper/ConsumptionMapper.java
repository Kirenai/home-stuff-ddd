package me.kire.re.consumption.infrastructure.mapper;

import me.kire.re.consumption.domain.model.Consumption;
import me.kire.re.consumption.domain.model.dto.*;
import me.kire.re.consumption.infrastructure.entity.ConsumptionEntity;
import org.mapstruct.Mapper;

import java.util.Objects;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface ConsumptionMapper {

    //MapIn
    ConsumptionEntity mapInConsumptionToConsumptionEntity(Consumption consumption);

    default Consumption mapInCreateConsumptionRequestToConsumption(CreateConsumptionRequest createConsumptionRequest) {
        if (Objects.isNull(createConsumptionRequest)) {
            return null;
        }

        Consumption.ConsumptionBuilder builder = Consumption.builder();

        switch (createConsumptionRequest.type()) {
            case CreateConsumptionTypeUnitRequest typeUnit -> builder.unit(typeUnit.unit());
            case CreateConsumptionTypePercentageRequest typePercentage ->
                    builder.percentage(typePercentage.percentage());
        }

        return builder.build();
    }

    //MapOut
    Consumption mapOutConsumptionEntityToConsumption(ConsumptionEntity consumptionEntity);

    ListConsumptionsResponse mapOutConsumptionToListConsumptionsResponse(Consumption consumption);

    GetConsumptionResponse mapOutConsumptionToGetConsumptionResponse(Consumption consumption);

    CreateConsumptionResponse mapOutConsumptionToCreateConsumptionResponse(Consumption consumption);

}
