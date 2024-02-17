package me.kirenai.re.nourishment.infrastructure.config;

import me.kirenai.re.nourishment.application.service.NourishmentService;
import me.kirenai.re.nourishment.application.usecases.*;
import me.kirenai.re.nourishment.domain.port.out.NourishmentRepositoryPort;
import me.kirenai.re.nourishment.domain.port.out.NourishmentSortingRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public NourishmentService nourishmentService(NourishmentRepositoryPort nourishmentRepositoryPort,
                                                 NourishmentSortingRepositoryPort nourishmentSortingRepositoryPort) {
        return new NourishmentService(
                new GetNourishmentUseCase(nourishmentRepositoryPort),
                new ListNourishmentsUseCase(nourishmentRepositoryPort, nourishmentSortingRepositoryPort),
                new CreateNourishmentUseCase(nourishmentRepositoryPort),
                new UpdateNourishmentUseCase(nourishmentRepositoryPort),
                new DeleteNourishmentUseCase(nourishmentRepositoryPort)
        );
    }

}
