package me.kirenai.re.role.application.usecases;

import lombok.RequiredArgsConstructor;
import me.kirenai.re.role.domain.model.Role;
import me.kirenai.re.role.domain.port.in.UpdateRolePort;
import me.kirenai.re.role.domain.port.out.RoleRepositoryPort;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class UpdateRoleUseCase implements UpdateRolePort {

    private final RoleRepositoryPort roleRepositoryPort;

    @Override
    public Mono<Role> updateRole(Long roleId, Role role) {
        return this.roleRepositoryPort.updateRole(roleId, role);
    }

}
