package me.kirenai.re.consumption.infrastructure.config;

import me.kirenai.re.consumption.application.service.ConsumptionService;
import me.kirenai.re.consumption.application.usecases.CreateConsumptionUseCase;
import me.kirenai.re.consumption.application.usecases.GetConsumptionUseCase;
import me.kirenai.re.consumption.application.usecases.ListConsumptionsUseCase;
import me.kirenai.re.consumption.domain.port.out.client.KeycloakClientPort;
import me.kirenai.re.consumption.domain.port.out.client.NourishmentClientPort;
import me.kirenai.re.consumption.domain.port.out.repository.ConsumptionRepositoryPort;
import me.kirenai.re.consumption.domain.port.out.repository.ConsumptionSortingRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public ConsumptionService consumptionService(ConsumptionRepositoryPort consumptionRepositoryPort,
                                                 ConsumptionSortingRepositoryPort consumptionSortingRepositoryPort,
                                                 NourishmentClientPort nourishmentClientPort,
                                                 KeycloakClientPort keycloakClientPort) {
        return new ConsumptionService(
                new GetConsumptionUseCase(consumptionRepositoryPort),
                new ListConsumptionsUseCase(consumptionSortingRepositoryPort),
                new CreateConsumptionUseCase(consumptionRepositoryPort),
                nourishmentClientPort,
                keycloakClientPort
        );
    }

}
