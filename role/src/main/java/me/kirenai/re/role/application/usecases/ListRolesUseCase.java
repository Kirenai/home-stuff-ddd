package me.kirenai.re.role.application.usecases;

import lombok.RequiredArgsConstructor;
import me.kirenai.re.role.domain.model.Role;
import me.kirenai.re.role.domain.port.in.ListRolesPort;
import me.kirenai.re.role.domain.port.out.repository.RoleSortingRepositoryPort;
import me.kirenai.re.role.domain.port.out.dao.RoleUserRepositoryDaoPort;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class ListRolesUseCase implements ListRolesPort {


    private final RoleUserRepositoryDaoPort roleUserRepositoryDaoPort;
    private final RoleSortingRepositoryPort roleSortingRepositoryPort;

    @Override
    public Flux<Role> getRoles(Pageable pageable) {
        return this.roleSortingRepositoryPort.findAll(pageable);
    }

    @Override
    public Flux<Role> getRolesByUserId(Long userId) {
        return this.roleUserRepositoryDaoPort.findByUserId(userId);
    }

}
