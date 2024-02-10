package me.kirenai.re.user.application.service;

import lombok.RequiredArgsConstructor;
import me.kirenai.re.user.domain.model.User;
import me.kirenai.re.user.domain.port.in.*;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class UserService {

    private final GetUserPort getUserPort;
    private final ListUsersPort listUsersPort;
    private final CreateUserPort createUserPort;
    private final UpdateUserPort updateUserPort;
    private final DeleteUserPort deleteUserPort;

    public Flux<User> getUsers(Pageable pageable) {
        return this.listUsersPort.getUsers(pageable);
    }

    public Mono<User> getUserById(Long userId) {
        return this.getUserPort.getUserById(userId);
    }

    public Mono<User> createUser(User user) {
        return this.createUserPort.createUser(user);
    }

    public Mono<User> updateUser(Long userId, User user) {
        return this.updateUserPort.updateUser(userId, user);
    }

    public Mono<Void> deleteUser(Long userId) {
        return this.deleteUserPort.deleteUser(userId);
    }

}
