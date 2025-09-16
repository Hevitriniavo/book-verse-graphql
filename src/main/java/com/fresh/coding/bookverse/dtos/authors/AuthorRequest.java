package com.fresh.coding.bookverse.dtos.authors;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
public class AuthorRequest {

    @Getter
    @Setter
    @NotBlank(message = "Le nom de l'auteur est obligatoire")
    private @NonNull String name;
}
