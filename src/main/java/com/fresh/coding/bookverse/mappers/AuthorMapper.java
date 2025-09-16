package com.fresh.coding.bookverse.mappers;

import com.fresh.coding.bookverse.dtos.authors.AuthorRequest;
import com.fresh.coding.bookverse.dtos.authors.AuthorResponse;
import com.fresh.coding.bookverse.entities.Author;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class AuthorMapper {

    public AuthorResponse toResponse(Author author) {
        if (author == null) return null;
        return AuthorResponse.builder()
                .id(author.getId())
                .name(author.getName())
                .build();
    }

    public List<AuthorResponse> toResponseList(List<Author> authors) {
        return authors.stream()
                .map(AuthorMapper::toResponse)
                .collect(Collectors.toList());
    }

    public Author toEntity(AuthorRequest response) {
        if (response == null) return null;
        return Author.builder()
                .name(response.getName())
                .build();
    }
}
