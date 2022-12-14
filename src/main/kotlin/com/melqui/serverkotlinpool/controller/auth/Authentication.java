package com.melqui.serverkotlinpool.controller.auth;

import com.melqui.serverkotlinpool.dto.AuthDTO;
import com.melqui.serverkotlinpool.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000/", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class Authentication {

    @Autowired
    private AuthService authService;
    @PostMapping
    public Map<String, Object> sigInAndSignUp(@RequestBody @Valid AuthDTO authDTO){
        var token = this.authService.auth(authDTO.getAccess_token());

        return Collections.singletonMap("token",token);
    }
}
