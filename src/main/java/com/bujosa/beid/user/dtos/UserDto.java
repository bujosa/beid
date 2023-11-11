package com.bujosa.beid.user.dtos;

import com.bujosa.beid.user.entity.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    @Min(value = 2, message = "Name should have at least 2 characters")
    private String name;

    @Min(value = 2, message = "Last name should have at least 2 characters")
    private String lastName;

    @Email(message = "Email should be valid")
    private String email;

    public User convertToUser() {
        return new User(name, lastName, email);
    }
}
