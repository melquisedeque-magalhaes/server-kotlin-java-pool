package com.melqui.serverkotlinpool.controller.User;

import com.melqui.serverkotlinpool.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000/", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class User {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/count")
    public Map<String, Long> count() {
        var count = this.userRepository.count();

        return Collections.singletonMap("count",count);
    }
}
