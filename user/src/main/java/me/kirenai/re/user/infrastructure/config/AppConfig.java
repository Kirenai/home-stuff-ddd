package me.kirenai.re.user.infrastructure.config;

import me.kirenai.re.user.application.service.UserService;
import me.kirenai.re.user.application.usecases.CreateUserUseCase;
import me.kirenai.re.user.application.usecases.GetUserUseCase;
import me.kirenai.re.user.domain.port.out.UserRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public UserService userService(UserRepositoryPort userRepositoryPort) {
        return new UserService(
                new GetUserUseCase(userRepositoryPort),
                new CreateUserUseCase(userRepositoryPort)
        );
    }

}
