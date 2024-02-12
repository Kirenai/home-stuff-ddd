package me.kirenai.re.role.infrastructure.adapter;

import lombok.RequiredArgsConstructor;
import me.kirenai.re.role.domain.model.Role;
import me.kirenai.re.role.domain.port.out.RoleSortingRepositoryPort;
import me.kirenai.re.role.infrastructure.mapper.RoleMapper;
import me.kirenai.re.role.infrastructure.repository.RoleSortingRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
@RequiredArgsConstructor
public class RoleSortingRepositoryAdapter implements RoleSortingRepositoryPort {

    private final RoleSortingRepository roleSortingRepository;
    private final RoleMapper mapper;

    @Override
    public Flux<Role> findAll(Pageable pageable) {
        return this.roleSortingRepository.findAllBy(pageable)
                .map(this.mapper::mapOutRoleEntityToRole);
    }

}
