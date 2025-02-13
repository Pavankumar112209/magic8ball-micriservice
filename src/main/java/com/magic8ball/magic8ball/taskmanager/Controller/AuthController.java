package com.magic8ball.magic8ball.taskmanager.Controller;

import com.magic8ball.magic8ball.taskmanager.Service.UserService;
import com.magic8ball.magic8ball.taskmanager.dto.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth/user")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ApiResponseDto<UserResDto> save(@Valid @RequestBody UserReqDto user) {
        return userService.save(user);
    }

    @PostMapping("/login")
    public ApiResponseDto<JwtResDTO> login(@RequestBody LoginDTO loginDTO){
        return userService.login(loginDTO);
    }

}
