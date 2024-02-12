package me.kirenai.re.role.domain.model;

import lombok.*;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    private Long roleId;
    private String name;

}