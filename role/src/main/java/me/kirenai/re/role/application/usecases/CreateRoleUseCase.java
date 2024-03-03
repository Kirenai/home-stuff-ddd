package me.kirenai.re.role.application.usecases;

import lombok.RequiredArgsConstructor;
import me.kirenai.re.role.domain.model.Role;
import me.kirenai.re.role.domain.port.in.CreateRolePort;
import me.kirenai.re.role.domain.port.out.repository.RoleRepositoryPort;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CreateRoleUseCase implements CreateRolePort {

    private final RoleRepositoryPort roleRepositoryPort;

    @Override
    public Mono<Role> createRole(Role role) {
        return this.roleRepositoryPort.createRole(role);
    }
}
