package me.kirenai.re.role.infrastructure.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import me.kirenai.re.role.domain.model.Role;
import me.kirenai.re.role.infrastructure.entity.RoleEntity;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MapperUtils {

    public static RoleEntity loadRoleToRoleEntityByReference(Role role, RoleEntity roleEntity) {
        roleEntity.setName(role.getName());
        return roleEntity;
    }

}
