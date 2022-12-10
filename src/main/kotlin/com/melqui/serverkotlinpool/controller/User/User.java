package com.melqui.serverkotlinpool.controller.User;

import com.melqui.serverkotlinpool.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class User {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/count")
    public Map<String, Long> count() {
        var count = this.userRepository.count();

        return Collections.singletonMap("count",count);
    }
}
