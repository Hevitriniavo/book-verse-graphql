package com.fresh.coding.bookverse.dtos.auths;

import lombok.*;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@Builder
public class AuthResponse {
    private @NonNull String username;
    private @NonNull String accessToken;
}
