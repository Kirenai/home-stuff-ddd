package me.kirenai.re.user.domain.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateUserResponse {

    private Long userId;
    private String username;
    private String firstName;
    private String lastName;
    private Integer age;

}
