package me.kirenai.re.role.domain.model.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRoleResponse {

    private Long roleId;
    private String name;

}
