package me.kirenai.re.user.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.kirenai.re.user.domain.model.User;
import me.kirenai.re.user.domain.port.in.*;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final GetUserPort getUserPort;
    private final ListUsersPort listUsersPort;
    private final CreateUserPort createUserPort;
    private final UpdateUserPort updateUserPort;
    private final DeleteUserPort deleteUserPort;

    public Flux<User> getUsers(Pageable pageable) {
        log.info("Invoking UserService.getUsers method");
        return this.listUsersPort.getUsers(pageable);
    }

    public Mono<User> getUserById(Long userId) {
        log.info("Invoking UserService.getUserById method");
        return this.getUserPort.getUserById(userId);
    }

    public Mono<User> createUser(User user) {
        log.info("Invoking UserService.createUser method");
        return this.createUserPort.createUser(user);
    }

    public Mono<User> updateUser(Long userId, User user) {
        log.info("Invoking UserService.updateUser method");
        return this.updateUserPort.updateUser(userId, user);
    }

    public Mono<Void> deleteUser(Long userId) {
        log.info("Invoking UserService.deleteUser method");
        return this.deleteUserPort.deleteUser(userId);
    }

}
