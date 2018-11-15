package com.betul.mailapp.controller;

import com.betul.mailapp.model.User;
import com.betul.mailapp.model.UserCreateRequest;
import com.betul.mailapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody UserCreateRequest userCreateRequest) {
        userService.create(userCreateRequest);
    }

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }
}
