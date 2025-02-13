package com.magic8ball.magic8ball.taskmanager.dto;

import java.time.LocalDateTime;

public record UserResDto (String firstName, String lastName, String email, LocalDateTime createdAt) {
}
