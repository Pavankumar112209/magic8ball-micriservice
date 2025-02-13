package com.magic8ball.magic8ball.taskmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponseDto<T> {
    private boolean status;
    private int code;
    private String message;
    private T data;
}
