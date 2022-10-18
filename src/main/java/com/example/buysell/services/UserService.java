package com.example.buysell.services;

import com.example.buysell.enums.Role;
import com.example.buysell.models.User;
import com.example.buysell.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final boolean ACTIVE_USER = true;

    private final UserRepository userRepository;

    public boolean createUser(User user) {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            return false;
        }
        String email = user.getEmail();
        user.setActive(ACTIVE_USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.getRoles().add(Role.ROLE_USER);
        log.info("saving new user with email: {}", email);
        userRepository.save(user);
        return true;
    }
}
