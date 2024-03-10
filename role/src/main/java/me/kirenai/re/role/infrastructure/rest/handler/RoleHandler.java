package me.kirenai.re.role.infrastructure.rest.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.kirenai.re.role.application.service.RoleService;
import me.kirenai.re.role.domain.model.dto.CreateRoleRequest;
import me.kirenai.re.role.domain.model.dto.ListRolesResponse;
import me.kirenai.re.role.domain.model.dto.UpdateRoleRequest;
import me.kirenai.re.role.infrastructure.mapper.RoleMapper;
import me.kirenai.re.validation.Validator;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@RequiredArgsConstructor
public class RoleHandler {

    private final RoleService roleService;
    private final RoleMapper mapper;
    private final Validator validator;

    public Mono<ServerResponse> findAll(ServerRequest serverRequest) {
        log.info("Invoking RoleHandler.findAll method");
        int page = Integer.parseInt(serverRequest.queryParam("page").orElse("0"));
        int size = Integer.parseInt(serverRequest.queryParam("size").orElse("3"));
        String[] sort = serverRequest.queryParam("sort").orElse("roleId,ASC").split(",");
        PageRequest pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.valueOf(sort[1]), sort[0]));
        Flux<ListRolesResponse> response = this.roleService.getRoles(pageable)
                .map(this.mapper::mapOutRoleToListRolesResponse);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(response, ListRolesResponse.class);
    }

    public Mono<ServerResponse> findById(ServerRequest request) {
        log.info("Invoking RoleHandler.getRole method");
        String roleId = request.pathVariable("roleId");
        return this.roleService.getRoleById(Long.parseLong(roleId))
                .map(this.mapper::mapOutRoleToGetRoleResponse)
                .flatMap(response -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(response));
    }

    public Mono<ServerResponse> findAllByUserId(ServerRequest request) {
        log.info("Invoking RoleHandler.getRolesByUserId method");
        String userId = request.pathVariable("userId");
        Flux<ListRolesResponse> response = this.roleService.getRolesByUserId(Long.parseLong(userId))
                .map(this.mapper::mapOutRoleToListRolesResponse);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(response, ListRolesResponse.class);
    }

    public Mono<ServerResponse> create(ServerRequest request) {
        log.info("Invoking RoleHandler.save method");
        return request.bodyToMono(CreateRoleRequest.class)
                .doOnNext(this.validator::validate)
                .map(this.mapper::mapInCreateRoleRequestToUser)
                .flatMap(this.roleService::createRole)
                .map(this.mapper::mapOutRoleToCreateRoleResponse)
                .flatMap(response -> ServerResponse.status(HttpStatus.CREATED)
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(response));
    }

    public Mono<ServerResponse> createRoleUser(ServerRequest request) {
        log.info("Invoking RoleHandler.saveRoleUser method");
        String userId = request.pathVariable("userId");
        return this.roleService.createRoleUser(Long.parseLong(userId))
                .then(Mono.defer(() -> ServerResponse.status(HttpStatus.CREATED).build()));
    }

    public Mono<ServerResponse> update(ServerRequest request) {
        log.info("Invoking RoleHandler.update method");
        String roleId = request.pathVariable("roleId");
        return request.bodyToMono(UpdateRoleRequest.class)
                .doOnNext(this.validator::validate)
                .map(this.mapper::mapInUpdateRoleRequestToUser)
                .flatMap(role -> this.roleService.updateRole(Long.parseLong(roleId), role))
                .map(this.mapper::mapOutRoleToUpdateRoleResponse)
                .flatMap(response -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(response));
    }

}