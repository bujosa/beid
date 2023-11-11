package com.bujosa.beid.user.dtos;

import com.bujosa.beid.user.entity.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    // @NotBlank(message = "Name is mandatory")
    private String name;
    private String lastName;
    private String email;

    public User convertToUser() {
        return new User(name, lastName, email);
    }
}
