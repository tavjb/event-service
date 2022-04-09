package com.tav.eventservice.controllers;

import com.tav.eventservice.dto.JwtDto;
import com.tav.eventservice.dto.UserDto;
import com.tav.eventservice.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("authentication")
@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping
    public JwtDto authenticate(@RequestBody final UserDto user) {
        return authService.authenticate(user);
    }
}
