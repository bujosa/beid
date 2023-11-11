package com.bujosa.beid.user.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bujosa.beid.user.repository.UserRepository;
import com.bujosa.beid.common.exceptions.NotFoundException;
import com.bujosa.beid.user.dtos.UserDto;
import com.bujosa.beid.user.entity.User;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    Logger log = LoggerFactory.getLogger(UserService.class);

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(String id) throws NotFoundException {
        log.info("Getting user with id: {}", id);
        return userRepository.findById(id).orElseThrow(
                () -> new NotFoundException("User not found with id: " + id));
    }

    public User create(UserDto userDto) {
        return userRepository.save(userDto.convertToUser());
    }

    public User update(String id, UserDto userDto) throws NotFoundException {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found with id: " + id));
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
