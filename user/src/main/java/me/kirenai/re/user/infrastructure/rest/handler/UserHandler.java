package me.kirenai.re.user.infrastructure.rest.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.kirenai.re.user.application.service.UserService;
import me.kirenai.re.user.domain.model.dto.CreateUserRequest;
import me.kirenai.re.user.domain.model.dto.ListUsersResponse;
import me.kirenai.re.user.domain.model.dto.UpdateUserRequest;
import me.kirenai.re.user.infrastructure.mapper.UserMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static me.kirenai.re.user.infrastructure.util.Constants.USER_ID_PATH_PARAM;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserHandler {

    private final UserService userService;
    private final UserMapper mapper;

    public Mono<ServerResponse> findAll(ServerRequest serverRequest) {
        log.info("Invoking UserHandler.findAll method");
        int page = Integer.parseInt(serverRequest.queryParam("page").orElse("0"));
        int size = Integer.parseInt(serverRequest.queryParam("size").orElse("6"));
        String[] sort = serverRequest.queryParam("sort").orElse("userId,ASC").split(",");
        PageRequest pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.valueOf(sort[1]), sort[0]));
        Flux<ListUsersResponse> response = this.userService.getUsers(pageable)
                .map(this.mapper::mapOutUserToListUsersResponse);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(response, ListUsersResponse.class);
    }


    public Mono<ServerResponse> findById(ServerRequest serverRequest) {
        log.info("Invoking UserHandler.findById method");
        Long userId = Long.parseLong(serverRequest.pathVariable(USER_ID_PATH_PARAM));
        return this.userService.getUserById(userId)
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
