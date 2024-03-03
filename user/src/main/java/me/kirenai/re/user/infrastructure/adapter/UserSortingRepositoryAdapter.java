package me.kirenai.re.user.infrastructure.adapter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.kirenai.re.user.domain.model.User;
import me.kirenai.re.user.domain.port.out.UserSortingRepositoryPort;
import me.kirenai.re.user.infrastructure.mapper.UserMapper;
import me.kirenai.re.user.infrastructure.repository.UserSortingRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserSortingRepositoryAdapter implements UserSortingRepositoryPort {

    private final UserSortingRepository userSortingRepository;
    private final UserMapper mapper;

    @Override
    public Flux<User> findAll(Pageable pageable) {
        log.info("Invoking UserSortingRepositoryAdapter.findAll method");
        return this.userSortingRepository.findAllBy(pageable)
                .map(this.mapper::mapOutUserEntityToUser);
    }

}
