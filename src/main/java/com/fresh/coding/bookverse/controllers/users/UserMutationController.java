package com.fresh.coding.bookverse.controllers.users;

import com.fresh.coding.bookverse.dtos.users.UserRequest;
import com.fresh.coding.bookverse.dtos.users.UserResponse;
import com.fresh.coding.bookverse.services.users.UserMutationService;
import jakarta.annotation.security.PermitAll;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class UserMutationController {
    private final UserMutationService userMutationService;

    @PermitAll
    @MutationMapping
    public UserResponse register(@Argument @Valid UserRequest request){
        return userMutationService.register(request);
    }
}
