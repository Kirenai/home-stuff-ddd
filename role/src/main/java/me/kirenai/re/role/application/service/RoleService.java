package me.kirenai.re.role.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.kirenai.re.role.application.usecases.CreateRoleUseCase;
import me.kirenai.re.role.application.usecases.CreateRoleUserUseCase;
import me.kirenai.re.role.application.usecases.ListRolesUseCase;
import me.kirenai.re.role.application.usecases.UpdateRoleUseCase;
import me.kirenai.re.role.domain.model.Role;
import me.kirenai.re.role.domain.port.in.GetRolePort;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
public class RoleService {

    public static final String DEFAULT_ROLE = "ROLE_USER";

    private final GetRolePort getRolePort;
    private final ListRolesUseCase listRolesUseCase;
    private final CreateRoleUseCase createRoleUseCase;
    private final CreateRoleUserUseCase createRoleUserUseCase;
    private final UpdateRoleUseCase updateRoleUseCase;

    public Flux<Role> getRoles(Pageable pageable) {
        log.info("Invoking RoleService.getRoles method");
        return this.listRolesUseCase.getRoles(pageable);
    }

    public Mono<Role> getRoleById(Long roleId) {
        log.info("Invoking RoleService.getRoleById method");
        return this.getRolePort.getRoleById(roleId);
    }

    public Flux<Role> getRolesByUserId(Long userId) {
        log.info("Invoking RoleService.getRolesByUserId method");
        return this.listRolesUseCase.getRolesByUserId(userId);
    }

    public Mono<Role> createRole(Role role) {
        log.info("Invoking RoleService.create method");
        return this.createRoleUseCase.createRole(role);
    }

    public Mono<Void> createRoleUser(Long userId) {
        log.info("Invoking RoleService.createRoleUser method");
        return this.getRolePort.getRoleByName(DEFAULT_ROLE)
                .flatMap(role -> this.createRoleUserUseCase.createRoleUser(userId, role));
    }

    public Mono<Role> updateRole(Long roleId, Role role) {
        log.info("Invoking RoleService.update method");
        return this.updateRoleUseCase.updateRole(roleId, role);
    }

}