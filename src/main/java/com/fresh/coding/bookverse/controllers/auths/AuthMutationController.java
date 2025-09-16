package com.fresh.coding.bookverse.controllers.auths;

import com.fresh.coding.bookverse.dtos.auths.AuthRequest;
import com.fresh.coding.bookverse.dtos.auths.AuthResponse;
import com.fresh.coding.bookverse.services.auths.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class AuthMutationController {
    private final AuthService authService;

    @MutationMapping
    public AuthResponse login(@Argument AuthRequest request) {
        return authService.login(request);
    }
}
