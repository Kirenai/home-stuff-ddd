package me.kirenai.re.role.infrastructure.mapper;

import me.kirenai.re.role.domain.model.Role;
import me.kirenai.re.role.domain.model.dto.*;
import me.kirenai.re.role.infrastructure.entity.RoleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RoleMapper {

    //Map In
    RoleEntity mapInRoleToRoleEntity(Role role);

    Role mapInCreateRoleRequestToUser(CreateRoleRequest createRoleRequest);

    Role mapInUpdateRoleRequestToUser(UpdateRoleRequest updateRoleRequest);

    //Map Out
    Role mapOutRoleEntityToRole(RoleEntity roleEntity);

    GetRoleResponse mapOutRoleToGetRoleResponse(Role role);

    ListRolesResponse mapOutRoleToListRolesResponse(Role role);

    CreateRoleResponse mapOutRoleToCreateRoleResponse(Role role);

    UpdateRoleResponse mapOutRoleToUpdateRoleResponse(Role role);

}
