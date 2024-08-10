package me.kirenai.re.nourishment.infrastructure.repository;

import me.kirenai.re.nourishment.infrastructure.entity.NourishmentDocument;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MongoNourishmentRepository extends ReactiveMongoRepository<NourishmentDocument, String> {
}