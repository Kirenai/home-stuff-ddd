package me.kirenai.re.user.infrastructure.rest.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.kirenai.re.user.application.service.UserService;
import me.kirenai.re.user.domain.model.dto.CreateUserRequest;
import me.kirenai.re.user.domain.model.dto.ListUsersResponse;
import me.kirenai.re.user.domain.model.dto.UpdateUserRequest;
import me.kirenai.re.user.infrastructure.mapper.UserMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserHandler {
    public static String USER_ID_PATH_PARAM = "userId";

    private final UserService userService;
    private final UserMapper mapper;

    public Mono<ServerResponse> findAll(ServerRequest serverRequest) {
        log.info("Invoking UserHandler.findAll method");
        Flux<ListUsersResponse> response = this.userService.getUsers()
                .map(this.mapper::mapOutUserToListUsersResponse);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(response, ListUsersResponse.class);
    }

    public Mono<ServerResponse> findByEmail(ServerRequest serverRequest) {
        log.info("Invoking UserHandler.findByEmail method");
        String email = serverRequest.pathVariable("email");
        return this.userService.getUserBy(email)
                .map(this.mapper::mapOutUserToGetUserResponse)
                .flatMap(user -> ServerResponse.ok().bodyValue(user));
    }

    public Mono<ServerResponse> create(ServerRequest serverRequest) {
        log.info("Invoking UserHandler.create method");
        return serverRequest.bodyToMono(CreateUserRequest.class)
                .map(this.mapper::mapInCreateUserRequestToUser)
                .flatMap(this.userService::createUser)
                .map(this.mapper::mapOutUserToCreateUserResponse)
                .flatMap(user -> ServerResponse.status(HttpStatus.CREATED).bodyValue(user));
    }

    public Mono<ServerResponse> update(ServerRequest serverRequest) {
        log.info("Invoking UserHandler.update method");
        Long userId = Long.parseLong(serverRequest.pathVariable(USER_ID_PATH_PARAM));
        return serverRequest.bodyToMono(UpdateUserRequest.class)
                .map(this.mapper::mapInUpdateUserRequestToUser)
                .flatMap(user -> this.userService.updateUser(userId, user))
                .map(this.mapper::mapOutUserToUpdateUserResponse)
                .flatMap(user -> ServerResponse.ok().bodyValue(user));
    }

    public Mono<ServerResponse> delete(ServerRequest serverRequest) {
        log.info("Invoking UserHandler.delete method");
        Long userId = Long.parseLong(serverRequest.pathVariable(USER_ID_PATH_PARAM));
        return this.userService.deleteUser(userId)
                .then(Mono.defer(() -> ServerResponse.noContent().build()));
    }

}
