package me.kirenai.re.user.infrastructure.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import me.kirenai.re.user.domain.model.User;
import me.kirenai.re.user.infrastructure.entity.UserEntity;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MapperUtils {

    public static UserEntity loadUserToUserEntity(User user, UserEntity userEntity) {
        userEntity.setUsername(user.getUsername());
        userEntity.setPassword(user.getPassword());
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());
        userEntity.setAge(user.getAge());
        return userEntity;
    }

}
