package com.bujosa.beid.user.dtos;

import com.bujosa.beid.user.entity.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    @NotBlank(message = "Name is mandatory")
    @Size(min = 2, message = "Name should be at least 2 characters long")
    private String name;

    @NotBlank(message = "Last name is mandatory")
    @Size(min = 2, message = "Last name should be at least 2 characters long")
    private String lastName;

    @Email(message = "Email should be valid")
    private String email;

    public User convertToUser() {
        return new User(name, lastName, email);
    }
}
