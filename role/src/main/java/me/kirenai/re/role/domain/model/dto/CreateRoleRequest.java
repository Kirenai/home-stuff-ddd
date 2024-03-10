package me.kirenai.re.role.domain.model.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateRoleRequest {

    @NotEmpty
    @Size(max = 25)
    private String name;

}
