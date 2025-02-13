package com.magic8ball.magic8ball.taskmanager.dto;

import lombok.Getter;

@Getter
public class JwtResDTO {
    private String token;
    private String tokenType = "Bearer";

    public JwtResDTO(String token){
        this.token = token;
    }
}
