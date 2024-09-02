package me.kirenai.re.user.infrastructure.config;

import me.kirenai.re.user.application.service.UserService;
import me.kirenai.re.user.application.usecases.CreateUserUseCase;
import me.kirenai.re.user.application.usecases.DeleteUserUseCase;
import me.kirenai.re.user.application.usecases.GetUserUseCase;
import me.kirenai.re.user.application.usecases.ListUsersUseCase;
import me.kirenai.re.user.application.usecases.UpdateUserUseCase;
import me.kirenai.re.user.domain.port.out.client.KeycloakClientPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public UserService userService(KeycloakClientPort keycloakClientPort) {
        return new UserService(
                new GetUserUseCase(keycloakClientPort),
                new ListUsersUseCase(),
                new CreateUserUseCase(),
                new UpdateUserUseCase(),
                new DeleteUserUseCase()
        );
    }

}
