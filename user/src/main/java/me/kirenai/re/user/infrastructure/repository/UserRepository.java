package me.kirenai.re.user.infrastructure.repository;

import me.kirenai.re.user.infrastructure.entity.UserEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ReactiveCrudRepository<UserEntity, Long> {
}
