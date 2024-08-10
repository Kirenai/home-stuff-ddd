package me.kirenai.re.nourishment.infrastructure.repository;

import me.kirenai.re.nourishment.infrastructure.entity.NourishmentDocument;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface MongoNourishmentSortingRepository extends ReactiveMongoRepository<NourishmentDocument, String> {

    Flux<NourishmentDocument> findAllBy(Pageable pageable);

    Flux<NourishmentDocument> findAllByIsAvailable(Boolean isAvailable, Pageable pageable);

    Flux<NourishmentDocument> findAllByUserId(String userId, Pageable pageable);

}
