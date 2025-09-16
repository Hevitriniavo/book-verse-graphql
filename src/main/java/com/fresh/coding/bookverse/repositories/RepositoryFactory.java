package com.fresh.coding.bookverse.repositories;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class RepositoryFactory {
    private final Map<String, JpaRepository<?, ?>> repositories;

    @SuppressWarnings("unchecked")
    private <T extends JpaRepository<?, ?>> T getRepositoryFor(String name) {
        JpaRepository<?, ?> repository = repositories.get(name);
        if (repository == null) {
            throw new IllegalArgumentException(String.format("Repository %s not defined", name));
        }
        return (T) repository;
    }

    public UserRepository getUserRepo() {
        return getRepositoryFor("userRepository");
    }

    public AuthorRepository getAuthorRepo() {
        return getRepositoryFor("authorRepository");
    }
}
