package com.bujosa.beid.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bujosa.beid.user.repository.UserRepository;
import com.bujosa.beid.user.dtos.UserDto;
import com.bujosa.beid.user.entity.User;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    public User create(UserDto userDto) {
        return userRepository.save(userDto.convertToUser());
    }

    public User update(String id, UserDto userDto) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setName(userDto.getName());
            user.setLastName(userDto.getLastName());
            user.setEmail(userDto.getEmail());
            return userRepository.save(user);
        }
        return null;
    }

    public void delete(String id) {
        userRepository.deleteById(id);
    }


}
