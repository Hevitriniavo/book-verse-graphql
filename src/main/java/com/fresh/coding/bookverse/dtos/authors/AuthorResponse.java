package com.fresh.coding.bookverse.dtos.authors;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AuthorResponse {
    private @NonNull Long id;
    private @NonNull String name;
}
