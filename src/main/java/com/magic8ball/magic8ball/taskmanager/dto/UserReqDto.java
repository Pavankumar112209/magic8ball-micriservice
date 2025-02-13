package com.magic8ball.magic8ball.taskmanager.dto;

import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserReqDto {

    @NotBlank(message = "first name should not be blank")
    @Size(min = 2,message = "minimum length should be 2")
    @Pattern(regexp = "[a-zA-Z ]+$", message = "text and spaces only allowed in first name")
    private String firstName;

    @Size(min = 2,message = "minimum length should be 2")
    @Pattern(regexp = "[a-zA-Z ]+$", message = "text only allowed in last name")
    @NotBlank(message = "last name should not be blank")
    private String lastName;

    @NotBlank(message = "email should not be blank")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",
            message = "Please enter a valid email address")
    private String email;

    @NotBlank
    @Size(min = 8)
    private String password;

}
