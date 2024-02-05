package me.kirenai.re.user.infrastructure.rest.handler;

import lombok.RequiredArgsConstructor;
import me.kirenai.re.user.application.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class UserHandler {

    private final UserService userService;

    public Mono<ServerResponse> findById(ServerRequest serverRequest) {
        Long userId = Long.parseLong(serverRequest.pathVariable("userId"));
        return this.userService.getUserById(userId)
                .flatMap(user -> ServerResponse.ok().bodyValue(user));
    }

    //TODO: end this
    public Mono<ServerResponse> create(ServerRequest serverRequest) {
        return null;
    }
}
