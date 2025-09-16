package com.fresh.coding.bookverse.services.users;

import com.fresh.coding.bookverse.dtos.users.UserRequest;
import com.fresh.coding.bookverse.dtos.users.UserResponse;

public interface UserMutationService {
    UserResponse register(UserRequest request);
}
