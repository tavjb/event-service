package com.tav.eventservice.controllers;

import com.tav.eventservice.dto.UserDto;
import com.tav.eventservice.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("user")
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UserDto create(@RequestBody final UserDto userDto) {
        return userService.create(userDto);
    }

    @GetMapping("{id}")
    public UserDto get(@PathVariable final long id) {
        return userService.get(id);
    }
}
