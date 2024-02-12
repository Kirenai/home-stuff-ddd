package me.kirenai.re.role.domain.model.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ListRolesResponse {

    private Long roleId;
    private String name;

}
