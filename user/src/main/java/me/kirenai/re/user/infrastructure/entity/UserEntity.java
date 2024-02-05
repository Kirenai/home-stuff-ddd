package me.kirenai.re.user.infrastructure.entity;

import lombok.*;
import me.kirenai.re.user.domain.model.User;
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

    public static UserEntity fromDomainModel(User user) {
        return UserEntity
                .builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .age(user.getAge())
                .build();
    }

    public User toDomainModel() {
        return User
                .builder()
                .userId(this.userId)
                .username(this.username)
                .password(this.password)
                .firstName(this.firstName)
                .lastName(this.lastName)
                .age(this.age)
                .build();
    }

}
