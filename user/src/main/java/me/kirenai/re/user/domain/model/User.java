package me.kirenai.re.user.domain.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long userId;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Integer age;

}
