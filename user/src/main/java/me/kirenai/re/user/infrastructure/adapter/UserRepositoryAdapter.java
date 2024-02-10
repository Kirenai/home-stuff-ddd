package me.kirenai.re.user.infrastructure.adapter;

import lombok.RequiredArgsConstructor;
import me.kirenai.re.user.domain.model.User;
import me.kirenai.re.user.domain.port.out.UserRepositoryPort;
import me.kirenai.re.user.infrastructure.mapper.UserMapper;
import me.kirenai.re.user.infrastructure.repository.UserRepository;
import me.kirenai.re.user.infrastructure.util.MapperUtils;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class UserRepositoryAdapter implements UserRepositoryPort {

    private final UserRepository userRepository;
    private final UserMapper mapper;

    @Override
    public Mono<User> findById(Long userId) {
        return this.userRepository.findById(userId)
                .map(this.mapper::mapOutUserEntityToUser);
    }

    @Override
    public Mono<User> createUser(User user) {
        return Mono.just(this.mapper.mapInUserToUserEntity(user))
                .flatMap(this.userRepository::save)
                .map(this.mapper::mapOutUserEntityToUser);
    }

    @Override
    public Mono<User> updateUser(Long userId, User user) {
        return this.userRepository.findById(userId)
                .map(userEntity -> MapperUtils.loadUserToUserEntity(user, userEntity))
                .flatMap(this.userRepository::save)
                .map(this.mapper::mapOutUserEntityToUser);
    }

    @Override
    public Mono<Void> deleteUser(Long userId) {
        return this.userRepository.findById(userId)
                .flatMap(this.userRepository::delete);
    }

}
