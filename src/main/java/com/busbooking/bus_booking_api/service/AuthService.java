package com.busbooking.bus_booking_api.service;

import com.busbooking.bus_booking_api.dto.LoginRequest;
import com.busbooking.bus_booking_api.dto.LoginResponse;
import com.busbooking.bus_booking_api.entity.User;
import com.busbooking.bus_booking_api.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public LoginResponse login(LoginRequest request){
        User user = userRepository.findByUsername(request.getUsername()).orElse(null);

        if(user == null){
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED,"Invalid username or password"
            );
        }

        if(!passwordEncoder.matches(
                request.getPassword(),
                user.getPassword()
        )){
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED,"Invalid username or password"
            );
        }

        String token = jwtService.generateToken(
                user.getUsername(),
                user.getRole()
        );

        return new LoginResponse(token,user.getUsername(),user.getRole());
    }
}
