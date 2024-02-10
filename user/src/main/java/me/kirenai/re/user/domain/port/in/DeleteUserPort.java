package me.kirenai.re.user.domain.port.in;

import reactor.core.publisher.Mono;

public interface DeleteUserPort {

    Mono<Void> deleteUser(Long userId);

}
