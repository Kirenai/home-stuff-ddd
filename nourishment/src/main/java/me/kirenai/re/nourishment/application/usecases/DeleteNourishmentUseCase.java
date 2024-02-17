package me.kirenai.re.nourishment.application.usecases;

import lombok.RequiredArgsConstructor;
import me.kirenai.re.nourishment.domain.port.in.DeleteNourishmentPort;
import me.kirenai.re.nourishment.domain.port.out.NourishmentRepositoryPort;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class DeleteNourishmentUseCase implements DeleteNourishmentPort {

    private final NourishmentRepositoryPort nourishmentRepositoryPort;

    @Override
    public Mono<Void> deleteNourishment(Long nourishmentId) {
        return this.nourishmentRepositoryPort.deleteNourishment(nourishmentId);
    }

}
