package com.fresh.coding.bookverse.services.auths;

import com.fresh.coding.bookverse.dtos.auths.AuthRequest;
import com.fresh.coding.bookverse.dtos.auths.AuthResponse;

public interface AuthService {
    AuthResponse login(AuthRequest request);
}
