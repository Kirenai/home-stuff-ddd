package me.kirenai.re.nourishment.infrastructure.repository;

import me.kirenai.re.nourishment.domain.model.NourishmentType;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface MongoNourishmentTypeRepository extends ReactiveMongoRepository<NourishmentType, String> {

//    Mono<NourishmentType> findByName(String name);

}
