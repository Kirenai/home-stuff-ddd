package me.kirenai.re.role.domain.model.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateRoleResponse {

    private Long roleId;
    private String name;

}
