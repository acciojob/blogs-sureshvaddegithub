package com.driver.services;

import com.driver.RequestDtos.UserRequestDto;
import com.driver.UpdateDto.UserUpdateDto;
import com.driver.models.*;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository3;

    @Autowired
    BlogService blogService3;

    public void createUser(User user){
//        User user = new User(userRequestDto.getUsername(), userRequestDto.getPassword(), userRequestDto.getFirstName(), userRequestDto.getLastName());
        userRepository3.save(user);
    }

    public void deleteUser(int userId){
        userRepository3.deleteById(userId);
    }

    public void updateUser(User userUpdateDto){
        User user = userRepository3.findById(userUpdateDto.getId()).get();
        user.setUsername(userUpdateDto.getUsername());
        user.setPassword(userUpdateDto.getPassword());
        user.setFirstName(userUpdateDto.getFirstName());
        user.setLastName(userUpdateDto.getLastName());

        userRepository3.save(user);
    }

    public User findUserByUsername(String username){

        return userRepository3.findByUsername(username);
    }
}
