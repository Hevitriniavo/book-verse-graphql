package com.fresh.coding.bookverse.services.authors.impl;

import com.fresh.coding.bookverse.dtos.authors.AuthorResponse;
import com.fresh.coding.bookverse.mappers.AuthorMapper;
import com.fresh.coding.bookverse.repositories.RepositoryFactory;
import com.fresh.coding.bookverse.services.authors.AuthorQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorQueryServiceImpl implements AuthorQueryService {
    private final RepositoryFactory repositoryFactory;

    @Override
    public List<AuthorResponse> allAuthors() {
        final var authorRepo = repositoryFactory.getAuthorRepo();
        final var authors = authorRepo.findAll();
        return AuthorMapper.toResponseList(authors);
    }
}
