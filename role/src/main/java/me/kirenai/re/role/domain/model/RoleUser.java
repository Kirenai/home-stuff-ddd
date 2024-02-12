package me.kirenai.re.role.domain.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleUser {

    private Long roleId;
    private Long userId;

    @Builder.Default
    private List<Role> roles = new ArrayList<>();

}