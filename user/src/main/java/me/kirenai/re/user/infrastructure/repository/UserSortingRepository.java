package me.kirenai.re.user.infrastructure.repository;

import me.kirenai.re.user.infrastructure.entity.UserEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface UserSortingRepository extends ReactiveSortingRepository<UserEntity, Long> {

    Flux<UserEntity> findAllBy(Pageable pageable);

}
