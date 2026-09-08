package com.busbooking.bus_booking_api.controller;

import com.busbooking.bus_booking_api.dto.LoginRequest;
import com.busbooking.bus_booking_api.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService){
        this.authService = authService;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request){
        return authService.login(request);
    }
}
