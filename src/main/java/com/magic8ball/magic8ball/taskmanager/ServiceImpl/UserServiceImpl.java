package com.magic8ball.magic8ball.taskmanager.ServiceImpl;

import com.magic8ball.magic8ball.taskmanager.Entities.UserEntity;
import com.magic8ball.magic8ball.taskmanager.Repository.UserRepository;
import com.magic8ball.magic8ball.taskmanager.Service.UserService;
import com.magic8ball.magic8ball.taskmanager.config.JwtTokenProvider;
import com.magic8ball.magic8ball.taskmanager.dto.*;
import com.magic8ball.magic8ball.taskmanager.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    public ApiResponseDto<UserResDto> save(UserReqDto user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        UserEntity userEntity = userRepository.save(UserMapper.MAPPER.userDTOToUserEntity(user));

        return new ApiResponseDto<>(true, HttpStatus.CREATED.value(),
                "user added successfully",
                UserMapper.MAPPER.userEntityToUserDTO(userEntity));
    }

    @Override
    public ApiResponseDto<JwtResDTO> login(LoginDTO loginDTO) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword())
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return new ApiResponseDto<>(true, HttpStatus.ACCEPTED.value(), "User Login successfully",new JwtResDTO(jwtTokenProvider.generateToken(authentication)));
        } catch (BadCredentialsException e) {
            return new ApiResponseDto<>(false, HttpStatus.UNAUTHORIZED.value(), "Invalid credentials. Please check your email and password.", null);
        }
    }
}
