package com.busbooking.bus_booking_api.service;

import com.busbooking.bus_booking_api.dto.LoginRequest;
import com.busbooking.bus_booking_api.entity.User;
import com.busbooking.bus_booking_api.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(UserRepository userRepository,PasswordEncoder passwordEncoder,JwtService jwtService){
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    public String login(LoginRequest request){
        User user = userRepository.findByUsername(request.getUsername()).orElse(null);

        if(user == null)
            return "User not Found";
        if(!passwordEncoder.matches(request.getPassword(), user.getPassword()))
            return "Wrong Password";

        return jwtService.generateToken(user.getUsername());
    }



}
