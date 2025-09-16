package com.fresh.coding.bookverse.services.auths;

import com.fresh.coding.bookverse.repositories.RepositoryFactory;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerUserDetailsService implements UserDetailsService {
    private final RepositoryFactory repositoryFactory;

    @Override
    @SneakyThrows(UsernameNotFoundException.class)
    public UserDetails loadUserByUsername(String username) {
        var userRepo = repositoryFactory.getUserRepo();
        return userRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
    }

}
