package com.jwt.auth.service;

import com.jwt.auth.entity.User;
import com.jwt.auth.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepo;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public User register(String email, String username, String password) {
        User user = new User();
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(encoder.encode(password));
        return userRepo.save(user);
    }

    public Optional<User> authenticate(String username, String password) {
        return userRepo.findByUsername(username)
                .filter(u -> encoder.matches(password, u.getPassword()));
    }

}
