package me.kire.re.consumption.util;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.kire.re.consumption.domain.model.Consumption;
import me.kire.re.consumption.domain.model.dto.*;
import me.kire.re.consumption.util.enums.NourishmentTypeEnum;

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
            if (this.consumption.getPercentage() > typePercentageResponse.percentage()) {
                log.error("Percentage exceeded c.percentage={} is greater than nr.percentage={}",
                        this.consumption.getPercentage(), typePercentageResponse.percentage());
                throw new IllegalStateException("percentage exceeded");
            }
            UpdateNourishmentTypePercentageRequest updateNourishmentTypePercentageRequest = UpdateNourishmentTypePercentageRequest
                    .builder()
                    .nourishmentType(NourishmentTypeEnum.PERCENTAGE)
                    .percentage(typePercentageResponse.percentage() - this.consumption.getPercentage())
                    .build();
            builder.type(updateNourishmentTypePercentageRequest);
        }

        return builder.build();
    }

}