package me.kire.re.consumption.domain.port.out.client;

import me.kire.re.consumption.domain.model.dto.GetUserResponse;
import reactor.core.publisher.Mono;

public interface UserClientPort {

    Mono<GetUserResponse> getUserByUserId(Long userId);

}
