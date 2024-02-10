package me.kirenai.re.user.infrastructure.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Builder
@Table("users")
@AllArgsConstructor
@RequiredArgsConstructor
public class UserEntity {

    @Id
    private Long userId;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Integer age;

}
