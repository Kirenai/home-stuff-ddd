package me.kirenai.re.role.application.usecases;

import lombok.RequiredArgsConstructor;
import me.kirenai.re.role.domain.model.Role;
import me.kirenai.re.role.domain.port.in.GetRolePort;
import me.kirenai.re.role.domain.port.out.repository.RoleRepositoryPort;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class GetRoleUseCase implements GetRolePort {

    private final RoleRepositoryPort roleRepositoryPort;

    @Override
    public Mono<Role> getRoleById(Long roleId) {
        return this.roleRepositoryPort.findById(roleId);
    }

    @Override
    public Mono<Role> getRoleByName(String name) {
        return this.roleRepositoryPort.findByName(name);
    }

}
