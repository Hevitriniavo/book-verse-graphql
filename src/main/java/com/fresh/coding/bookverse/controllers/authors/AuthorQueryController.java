package com.fresh.coding.bookverse.controllers.authors;

import com.fresh.coding.bookverse.dtos.authors.AuthorResponse;
import com.fresh.coding.bookverse.services.authors.AuthorQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('ROLE_USER')")
public class AuthorQueryController {
    private final AuthorQueryService authorQueryService;

    @QueryMapping
    public List<AuthorResponse> allAuthorsOnly() {
        return authorQueryService.allAuthors();
    }
}
