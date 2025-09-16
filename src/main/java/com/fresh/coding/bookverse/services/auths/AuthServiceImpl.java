package com.fresh.coding.bookverse.services.auths;

import com.fresh.coding.bookverse.dtos.auths.AuthRequest;
import com.fresh.coding.bookverse.dtos.auths.AuthResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class AuthServiceImpl implements AuthService{
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthResponse login(AuthRequest request) {
        Authentication authenticationRequest = UsernamePasswordAuthenticationToken.unauthenticated(
                request.getUsername(),
                request.getPassword()
        );
        final var authentication = authenticationManager.authenticate(authenticationRequest);
        final var userDetails = (UserDetails) authentication.getPrincipal();
        final var token = jwtService.generateToken(userDetails);
        return new AuthResponse(request.getUsername(), token);
    }
}
