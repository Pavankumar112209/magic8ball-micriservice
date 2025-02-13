package com.magic8ball.magic8ball.taskmanager.Service;

import com.magic8ball.magic8ball.taskmanager.dto.*;

public interface UserService {

     ApiResponseDto<UserResDto> save(UserReqDto user);
     ApiResponseDto<JwtResDTO> login(LoginDTO loginDTO);
}
