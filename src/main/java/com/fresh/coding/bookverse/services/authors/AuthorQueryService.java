package com.fresh.coding.bookverse.services.authors;

import com.fresh.coding.bookverse.dtos.authors.AuthorResponse;

import java.util.List;

public interface AuthorQueryService {
    List<AuthorResponse> allAuthors();
}
