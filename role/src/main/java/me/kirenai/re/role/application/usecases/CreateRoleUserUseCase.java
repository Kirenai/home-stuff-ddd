package me.kirenai.re.role.application.usecases;

import lombok.RequiredArgsConstructor;
import me.kirenai.re.role.domain.model.Role;
import me.kirenai.re.role.domain.port.in.CreateRoleUserPort;
import me.kirenai.re.role.domain.port.out.RoleUserRepositoryDaoPort;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CreateRoleUserUseCase implements CreateRoleUserPort {

    private final RoleUserRepositoryDaoPort roleUserRepositoryDaoPort;

    @Override
    public Mono<Void> createRoleUser(Long userId, Role role) {
        return this.roleUserRepositoryDaoPort.saveRoleUser(userId, role);
    }

}
