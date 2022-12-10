package com.melqui.serverkotlinpool.services;

import com.melqui.serverkotlinpool.model.User;
import com.melqui.serverkotlinpool.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;
    public User createUser(User user) {
        return this.userRepository.save(user);
    }

    public Optional<User> profile(String id) {
        return this.userRepository.findById(id);
    }
}
