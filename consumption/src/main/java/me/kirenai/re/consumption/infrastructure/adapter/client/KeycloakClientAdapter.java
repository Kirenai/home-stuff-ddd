package me.kirenai.re.consumption.infrastructure.adapter.client;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.kirenai.re.consumption.domain.exception.KeycloakUserNotFoundException;
import me.kirenai.re.consumption.domain.port.out.client.KeycloakClientPort;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@RequiredArgsConstructor
public class KeycloakClientAdapter implements KeycloakClientPort {
    private final Keycloak keycloak;

    @Override
    public Mono<String> getUserIdByEmail(String email) {
        log.info("Invoking KeycloakClientAdapter.getUserIdByEmail method");
        return Mono.fromCallable(() -> this.keycloak.realm("hs-realm").users().searchByEmail(email, true))
                .flatMapMany(Flux::fromIterable)
                .map(UserRepresentation::getId)
                .next()
                .switchIfEmpty(Mono.error(new KeycloakUserNotFoundException("User not found by email")));
    }
}
