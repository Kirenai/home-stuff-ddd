package me.kirenai.re.role.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.kirenai.re.role.domain.model.Role;
import me.kirenai.re.role.domain.model.RoleUser;
import me.kirenai.re.role.domain.port.in.*;
import me.kirenai.re.role.domain.port.out.client.UserClientPort;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
public class RoleService {

    public static final String DEFAULT_ROLE = "ROLE_USER";

    private final GetRolePort getRolePort;
    private final ListRolesPort listRolesPort;
    private final CreateRolePort createRolePort;
    private final CreateRoleUserPort createRoleUserPort;
    private final UpdateRolePort updateRolePort;
    private final UserClientPort userClientPort;

    public Flux<Role> getRoles(Pageable pageable) {
        log.info("Invoking RoleService.getRoles method");
        return this.listRolesPort.getRoles(pageable);
    }

    public Mono<Role> getRoleById(Long roleId) {
        log.info("Invoking RoleService.getRoleById method");
        return this.getRolePort.getRoleById(roleId);
    }

    public Flux<Role> getRolesByUserId(Long userId) {
        log.info("Invoking RoleService.getRolesByUserId method");
        return this.listRolesPort.getRolesByUserId(userId);
    }

    public Mono<Role> createRole(Role role) {
        log.info("Invoking RoleService.create method");
        return this.createRolePort.createRole(role);
    }

    public Mono<Void> createRoleUser(Long userId) {
        log.info("Invoking RoleService.createRoleUser method");
        return this.getRolePort.getRoleByName(DEFAULT_ROLE)
                .zipWith(this.userClientPort.getUserByUserId(userId),
                        (role, userResponse) -> RoleUser
                                .builder()
                                .roleId(role.getRoleId())
                                .userId(userResponse.userId())
                                .build())
                .flatMap(this.createRoleUserPort::createRoleUser);
    }

    public Mono<Role> updateRole(Long roleId, Role role) {
        log.info("Invoking RoleService.update method");
        return this.updateRolePort.updateRole(roleId, role);
    }

}