package me.kirenai.re.user.infrastructure.mapper;

import me.kirenai.re.user.domain.model.User;
import me.kirenai.re.user.domain.model.dto.CreateUserRequest;
import me.kirenai.re.user.domain.model.dto.CreateUserResponse;
import me.kirenai.re.user.domain.model.dto.GetUserResponse;
import me.kirenai.re.user.domain.model.dto.ListUsersResponse;
import me.kirenai.re.user.domain.model.dto.UpdateUserRequest;
import me.kirenai.re.user.domain.model.dto.UpdateUserResponse;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface UserMapper {

    // MapIn
    User mapInCreateUserRequestToUser(CreateUserRequest createUserRequest);

    User mapInUpdateUserRequestToUser(UpdateUserRequest updateUserRequest);

    // MapOut
    GetUserResponse mapOutUserToGetUserResponse(User user);

    ListUsersResponse mapOutUserToListUsersResponse(User user);

    CreateUserResponse mapOutUserToCreateUserResponse(User user);

    UpdateUserResponse mapOutUserToUpdateUserResponse(User user);

}
