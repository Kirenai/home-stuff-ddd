package me.kirenai.re.user.infrastructure.mapper;

import me.kirenai.re.user.domain.model.User;
import me.kirenai.re.user.domain.model.dto.*;
import me.kirenai.re.user.infrastructure.entity.UserEntity;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface UserMapper {

    // MapIn
    User mapInCreateUserRequestToUser(CreateUserRequest createUserRequest);

    User mapInUpdateUserRequestToUser(UpdateUserRequest updateUserRequest);

    UserEntity mapInUserToUserEntity(User user);

    // MapOut
    User mapOutUserEntityToUser(UserEntity userEntity);

    GetUserResponse mapOutUserToGetUserResponse(User user);

    ListUsersResponse mapOutUserToListUsersResponse(User user);

    CreateUserResponse mapOutUserToCreateUserResponse(User user);

    UpdateUserResponse mapOutUserToUpdateUserResponse(User user);

}
