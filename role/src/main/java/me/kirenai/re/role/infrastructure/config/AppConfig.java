package me.kirenai.re.role.infrastructure.config;

import me.kirenai.re.role.application.service.RoleService;
import me.kirenai.re.role.application.usecases.*;
import me.kirenai.re.role.domain.port.out.RoleRepositoryPort;
import me.kirenai.re.role.domain.port.out.RoleSortingRepositoryPort;
import me.kirenai.re.role.domain.port.out.RoleUserRepositoryDaoPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public RoleService roleService(RoleRepositoryPort roleRepositoryPort,
                                   RoleUserRepositoryDaoPort roleUserRepositoryDaoPort,
                                   RoleSortingRepositoryPort roleSortingRepositoryPort) {
        return new RoleService(
                new GetRoleUseCase(roleRepositoryPort),
                new ListRolesUseCase(roleUserRepositoryDaoPort, roleSortingRepositoryPort),
                new CreateRoleUseCase(roleRepositoryPort),
                new CreateRoleUserUseCase(roleUserRepositoryDaoPort),
                new UpdateRoleUseCase(roleRepositoryPort)
        );
    }

}
