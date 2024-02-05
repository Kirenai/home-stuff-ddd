package me.kirenai.re.user.application.service;

import lombok.RequiredArgsConstructor;
import me.kirenai.re.user.domain.model.User;
import me.kirenai.re.user.domain.port.in.CreateUserPort;
import me.kirenai.re.user.domain.port.in.GetUserPort;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class UserService {

    private final GetUserPort getUserPort;
    private final CreateUserPort createUserPort;

    public Mono<User> getUserById(Long userId) {
        return this.getUserPort.getUserById(userId);
    }

    public Mono<User> createUser(User user) {
        return this.createUserPort.createUser(user);
    }

}
