package me.kirenai.re.user.infrastructure.config;

import me.kirenai.re.user.application.service.UserService;
import me.kirenai.re.user.application.usecases.*;
import me.kirenai.re.user.domain.port.out.UserRepositoryPort;
import me.kirenai.re.user.domain.port.out.UserSortingRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public UserService userService(UserRepositoryPort userRepositoryPort,
                                   UserSortingRepositoryPort userSortingRepositoryPort) {
        return new UserService(
                new GetUserUseCase(userRepositoryPort),
                new ListUsersUseCase(userSortingRepositoryPort),
                new CreateUserUseCase(userRepositoryPort),
                new UpdateUserUseCase(userRepositoryPort),
                new DeleteUserUseCase(userRepositoryPort)
        );
    }

}
