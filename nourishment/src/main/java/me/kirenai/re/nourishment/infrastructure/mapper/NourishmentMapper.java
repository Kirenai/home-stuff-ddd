package me.kirenai.re.nourishment.infrastructure.mapper;

import me.kirenai.re.nourishment.domain.model.Nourishment;
import me.kirenai.re.nourishment.domain.model.dto.CreateNourishmentRequest;
import me.kirenai.re.nourishment.domain.model.dto.ListNourishmentsResponse;
import me.kirenai.re.nourishment.domain.model.dto.UpdateNourishmentRequest;
import me.kirenai.re.nourishment.infrastructure.entity.NourishmentEntity;
import org.mapstruct.MapperConfig;
import reactor.core.publisher.Mono;

@MapperConfig
public interface NourishmentMapper {

    // Map In
    NourishmentEntity mapInNourishmentToNourishmentEntity(Nourishment nourishment);

    Mono<Nourishment> mapInCreateNourishmentRequestToNourishment(CreateNourishmentRequest createNourishmentRequest);

    Nourishment mapInNourishment(CreateNourishmentRequest createNourishmentRequest);

    Mono<Nourishment> mapInUpdateNourishmentRequestToNourishment(UpdateNourishmentRequest updateNourishmentRequest);

    Nourishment mapInNourishment(UpdateNourishmentRequest updateNourishmentRequest);

    // Map Out
    Nourishment mapOutNourishmentEntityToNourishment(NourishmentEntity nourishmentEntity);

    Mono<ListNourishmentsResponse> mapOutNourishmentToListNourishmentsResponse(Nourishment nourishment);

    ListNourishmentsResponse mapOutListNourishmentsResponse(Nourishment nourishment);

}
