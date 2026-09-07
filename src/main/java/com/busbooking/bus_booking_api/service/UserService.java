package com.busbooking.bus_booking_api.service;

import com.busbooking.bus_booking_api.entity.User;
import com.busbooking.bus_booking_api.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    public User getUserById( Integer id){
        return userRepository.findById(id).orElse(null);
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public User updateUser( Integer id,User user){
        User existingUser = userRepository.findById(id).orElse(null);

        if(existingUser == null){
            return null;
        }

        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setUsername(user.getUsername());
        existingUser.setPassword(user.getPassword());
        existingUser.setRole(user.getRole());

        return userRepository.save(existingUser);
    }

    public boolean deleteUserById(Integer id){
        if(!userRepository.existsById(id))
            return false;

        userRepository.deleteById(id);
        return true;
    }


}
