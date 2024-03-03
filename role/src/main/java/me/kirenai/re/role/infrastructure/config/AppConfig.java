package me.kirenai.re.role.infrastructure.config;

import me.kirenai.re.role.application.service.RoleService;
import me.kirenai.re.role.application.usecases.*;
import me.kirenai.re.role.domain.port.out.repository.RoleRepositoryPort;
import me.kirenai.re.role.domain.port.out.repository.RoleSortingRepositoryPort;
import me.kirenai.re.role.domain.port.out.dao.RoleUserRepositoryDaoPort;
import me.kirenai.re.role.domain.port.out.client.UserClientPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public RoleService roleService(RoleRepositoryPort roleRepositoryPort,
                                   RoleUserRepositoryDaoPort roleUserRepositoryDaoPort,
                                   RoleSortingRepositoryPort roleSortingRepositoryPort,
                                   UserClientPort userClientPort) {
        return new RoleService(
                new GetRoleUseCase(roleRepositoryPort),
                new ListRolesUseCase(roleUserRepositoryDaoPort, roleSortingRepositoryPort),
                new CreateRoleUseCase(roleRepositoryPort),
                new CreateRoleUserUseCase(roleUserRepositoryDaoPort),
                new UpdateRoleUseCase(roleRepositoryPort),
                userClientPort
        );
    }

}
