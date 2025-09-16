package com.fresh.coding.bookverse.dtos.users;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class UserResponse {
    private Long id;
    private String username;
}
