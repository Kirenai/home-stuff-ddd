package me.kirenai.re.role.infrastructure.adapter.repository;

import lombok.RequiredArgsConstructor;
import me.kirenai.re.role.domain.model.Role;
import me.kirenai.re.role.domain.port.out.repository.RoleRepositoryPort;
import me.kirenai.re.role.infrastructure.mapper.RoleMapper;
import me.kirenai.re.role.infrastructure.repository.RoleRepository;
import me.kirenai.re.role.infrastructure.util.MapperUtils;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class RoleRepositoryAdapter implements RoleRepositoryPort {

    private final RoleRepository roleRepository;
    private final RoleMapper mapper;

    @Override
    public Mono<Role> findById(Long roleId) {
        return this.roleRepository.findById(roleId)
                .map(this.mapper::mapOutRoleEntityToRole);
    }

    @Override
    public Mono<Role> findByName(String name) {
        return this.roleRepository.findByName(name)
                .map(this.mapper::mapOutRoleEntityToRole);
    }

    @Override
    public Mono<Role> createRole(Role role) {
        return Mono.just(this.mapper.mapInRoleToRoleEntity(role))
                .flatMap(this.roleRepository::save)
                .map(this.mapper::mapOutRoleEntityToRole);
    }

    @Override
    public Mono<Role> updateRole(Long roleId, Role role) {
        return this.roleRepository.findById(roleId)
                .map(roleEntity -> MapperUtils.loadRoleToRoleEntityByReference(role, roleEntity))
                .flatMap(this.roleRepository::save)
                .map(this.mapper::mapOutRoleEntityToRole);
    }

}
