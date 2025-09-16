package com.fresh.coding.bookverse.mappers;

import com.fresh.coding.bookverse.dtos.users.UserRequest;
import com.fresh.coding.bookverse.dtos.users.UserResponse;
import com.fresh.coding.bookverse.entities.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {

    public UserResponse toResponse(User user) {
        if (user == null) return null;
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .build();
    }


    public User toEntity(UserRequest request) {
        if (request == null) return null;
        return User.builder()
                .password(request.getPassword())
                .username(request.getUsername())
                .build();
    }
}
