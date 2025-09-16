package com.fresh.coding.bookverse.services.users.impl;

import com.fresh.coding.bookverse.dtos.users.UserRequest;
import com.fresh.coding.bookverse.dtos.users.UserResponse;
import com.fresh.coding.bookverse.mappers.UserMapper;
import com.fresh.coding.bookverse.repositories.RepositoryFactory;
import com.fresh.coding.bookverse.services.users.UserMutationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserMutationServiceImpl implements UserMutationService {
    private final RepositoryFactory repositoryFactory;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponse register(UserRequest request) {
        final var newUser = UserMapper.toEntity(request);
        final var hashPassword = passwordEncoder.encode(newUser.getPassword());
        newUser.setPassword(hashPassword);
        final var userRepo = repositoryFactory.getUserRepo();
        final var savedUser = userRepo.save(newUser);
        return UserMapper.toResponse(savedUser);
    }
}
