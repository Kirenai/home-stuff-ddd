package me.kire.re.consumption.infrastructure.config;

import me.kire.re.consumption.application.service.ConsumptionService;
import me.kire.re.consumption.application.usecases.CreateConsumptionUseCase;
import me.kire.re.consumption.application.usecases.GetConsumptionUseCase;
import me.kire.re.consumption.application.usecases.ListConsumptionsUseCase;
import me.kire.re.consumption.domain.port.out.client.NourishmentClientPort;
import me.kire.re.consumption.domain.port.out.client.UserClientPort;
import me.kire.re.consumption.domain.port.out.repository.ConsumptionRepositoryPort;
import me.kire.re.consumption.domain.port.out.repository.ConsumptionSortingRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public ConsumptionService consumptionService(ConsumptionRepositoryPort consumptionRepositoryPort,
                                                 ConsumptionSortingRepositoryPort consumptionSortingRepositoryPort,
                                                 UserClientPort userClientPort,
                                                 NourishmentClientPort nourishmentClientPort) {
        return new ConsumptionService(
                new GetConsumptionUseCase(consumptionRepositoryPort),
                new ListConsumptionsUseCase(consumptionSortingRepositoryPort),
                new CreateConsumptionUseCase(consumptionRepositoryPort),
                userClientPort,
                nourishmentClientPort
        );
    }

}
