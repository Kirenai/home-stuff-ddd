package me.kirenai.re.role.application.usecases;

import lombok.RequiredArgsConstructor;
import me.kirenai.re.role.domain.model.RoleUser;
import me.kirenai.re.role.domain.port.in.CreateRoleUserPort;
import me.kirenai.re.role.domain.port.out.dao.RoleUserRepositoryDaoPort;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CreateRoleUserUseCase implements CreateRoleUserPort {

    private final RoleUserRepositoryDaoPort roleUserRepositoryDaoPort;

    @Override
    public Mono<Void> createRoleUser(RoleUser roleUser) {
        return this.roleUserRepositoryDaoPort.saveRoleUser(roleUser);
    }

}
