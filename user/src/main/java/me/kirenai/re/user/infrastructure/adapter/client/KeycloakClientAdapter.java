package me.kirenai.re.user.infrastructure.adapter.client;

import jakarta.ws.rs.ProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.kirenai.re.user.domain.exception.KeycloakServiceUnavailableException;
import me.kirenai.re.user.domain.exception.KeycloakUserNotFoundException;
import me.kirenai.re.user.domain.model.User;
import me.kirenai.re.user.domain.port.out.client.KeycloakClientPort;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@RequiredArgsConstructor
public class KeycloakClientAdapter implements KeycloakClientPort {
    public static final String HS_REALM = "hs-realm";

    private final Keycloak keycloak;

    @Override
    public Mono<User> getUserBy(String email) {
        log.info("Invoking KeycloakClientAdapter.getUserIdByEmail method");
        return Mono.fromCallable(() -> this.keycloak.realm(HS_REALM).users().searchByEmail(email, true))
                .flatMapMany(Flux::fromIterable)
                .map(UserRepresentation::getId)
                .next()
                .switchIfEmpty(Mono.error(new KeycloakUserNotFoundException("User not found by email")))
                .map(userId -> User.builder().userId(userId).build())
                .onErrorResume(ProcessingException.class, e ->
                        Mono.error(new KeycloakServiceUnavailableException("Keycloak server is not available"))
                );
    }
}
