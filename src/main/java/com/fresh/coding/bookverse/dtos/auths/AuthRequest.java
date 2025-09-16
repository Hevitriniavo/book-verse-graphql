package com.fresh.coding.bookverse.dtos.auths;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AuthRequest {
    private String username;
    private String password;
}
