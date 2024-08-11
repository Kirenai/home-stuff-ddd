package me.kirenai.re.consumption.domain.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.kirenai.re.consumption.domain.enums.NourishmentTypeEnum;
import me.kirenai.re.consumption.domain.model.Consumption;
import me.kirenai.re.consumption.domain.model.dto.GetNourishmentResponse;
import me.kirenai.re.consumption.domain.model.dto.GetNourishmentTypePercentageResponse;
import me.kirenai.re.consumption.domain.model.dto.GetNourishmentTypeUnitResponse;
import me.kirenai.re.consumption.domain.model.dto.UpdateNourishmentRequest;
import me.kirenai.re.consumption.domain.model.dto.UpdateNourishmentTypePercentageRequest;
import me.kirenai.re.consumption.domain.model.dto.UpdateNourishmentTypeUnitRequest;

import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
public class ConsumptionProcess {

    private final Consumption consumption;

    public UpdateNourishmentRequest consumeToUpdateNourishmentRequest(GetNourishmentResponse nourishmentResponse) {
        log.info("Invoking ConsumptionProcess.process method");
        UpdateNourishmentRequest.UpdateNourishmentRequestBuilder builder = UpdateNourishmentRequest.builder();

        if (Objects.nonNull(this.consumption.getUnit())) {
            log.info("Unit: {}", this.consumption.getUnit());
            GetNourishmentTypeUnitResponse typeUnitResponse = (GetNourishmentTypeUnitResponse) nourishmentResponse.type();
            if (this.consumption.getUnit() > typeUnitResponse.unit()) {
                log.error("Unit exceeded c.unit={} is greater than nr.unit={}", this.consumption.getUnit(), typeUnitResponse.unit());
                throw new IllegalStateException("amount exceeded");
            }
            UpdateNourishmentTypeUnitRequest updateNourishmentTypeUnitRequest = UpdateNourishmentTypeUnitRequest
                    .builder()
                    .nourishmentType(NourishmentTypeEnum.UNIT)
                    .unit(typeUnitResponse.unit() - this.consumption.getUnit())
                    .build();
            builder.type(updateNourishmentTypeUnitRequest);
        } else if (Objects.nonNull(this.consumption.getPercentage())) {
            log.info("Percentage: {}", this.consumption.getPercentage());
            GetNourishmentTypePercentageResponse typePercentageResponse = (GetNourishmentTypePercentageResponse) nourishmentResponse.type();
            int intPercentage = (int) (typePercentageResponse.percentage() * 100);
            if (this.consumption.getPercentage() >  intPercentage) {
                log.error("Percentage exceeded c.percentage={} is greater than nr.percentage={}",
                        this.consumption.getPercentage(), typePercentageResponse.percentage());
                throw new IllegalStateException("percentage exceeded");
            }
            UpdateNourishmentTypePercentageRequest updateNourishmentTypePercentageRequest = UpdateNourishmentTypePercentageRequest
                    .builder()
                    .nourishmentType(NourishmentTypeEnum.PERCENTAGE)
                    .percentage(intPercentage - this.consumption.getPercentage())
                    .build();
            builder.type(updateNourishmentTypePercentageRequest);
        }
        builder.name(nourishmentResponse.name());
        builder.imageUrl(nourishmentResponse.imageUrl());
        builder.description(nourishmentResponse.description());

        return builder.build();
    }

}