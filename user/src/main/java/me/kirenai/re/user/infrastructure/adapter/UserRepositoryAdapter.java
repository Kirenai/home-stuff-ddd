package me.kirenai.re.user.infrastructure.adapter;

import lombok.RequiredArgsConstructor;
import me.kirenai.re.user.domain.model.User;
import me.kirenai.re.user.domain.port.out.UserRepositoryPort;
import me.kirenai.re.user.infrastructure.entity.UserEntity;
import me.kirenai.re.user.infrastructure.repository.UserRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class UserRepositoryAdapter implements UserRepositoryPort {

    private final UserRepository userRepository;

    @Override
    public Mono<User> findById(Long userId) {
        return this.userRepository.findById(userId).map(UserEntity::toDomainModel);
    }

    @Override
    public Mono<User> createUser(User user) {
        UserEntity userEntity = UserEntity.fromDomainModel(user);
        return this.userRepository.save(userEntity).map(UserEntity::toDomainModel);
    }

}
