package com.fresh.coding.bookverse.dtos.users;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class UserRequest {

    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
