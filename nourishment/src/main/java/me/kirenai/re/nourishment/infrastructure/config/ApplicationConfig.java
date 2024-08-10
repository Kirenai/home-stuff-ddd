package me.kirenai.re.nourishment.infrastructure.config;

import me.kirenai.re.nourishment.application.service.NourishmentService;
import me.kirenai.re.nourishment.application.usecases.CreateNourishmentUseCase;
import me.kirenai.re.nourishment.application.usecases.DeleteNourishmentUseCase;
import me.kirenai.re.nourishment.application.usecases.GetNourishmentUseCase;
import me.kirenai.re.nourishment.application.usecases.ListNourishmentsUseCase;
import me.kirenai.re.nourishment.application.usecases.UpdateNourishmentUseCase;
import me.kirenai.re.nourishment.domain.port.out.client.CategoryClientPort;
import me.kirenai.re.nourishment.domain.port.out.client.UserClientPort;
import me.kirenai.re.nourishment.domain.port.out.repository.NourishmentRepositoryPort;
import me.kirenai.re.nourishment.domain.port.out.repository.NourishmentSortingRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public NourishmentService nourishmentServiceMongo(NourishmentRepositoryPort nourishmentRepositoryPort,
                                                      NourishmentSortingRepositoryPort nourishmentSortingRepositoryPort,
                                                      UserClientPort userClientPort,
                                                      CategoryClientPort categoryClientPort) {
        return new NourishmentService(
                new GetNourishmentUseCase(nourishmentRepositoryPort),
                new ListNourishmentsUseCase(nourishmentSortingRepositoryPort),
                new CreateNourishmentUseCase(nourishmentRepositoryPort),
                new UpdateNourishmentUseCase(nourishmentRepositoryPort),
                new DeleteNourishmentUseCase(nourishmentRepositoryPort),
                userClientPort,
                categoryClientPort
        );
    }

}
