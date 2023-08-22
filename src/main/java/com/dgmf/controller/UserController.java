package com.dgmf.controller;

import com.dgmf.dto.RequestUserDTO;
import com.dgmf.dto.ResponseUserDTO;
import com.dgmf.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/user")
    public ResponseEntity<?> addUser(@RequestBody RequestUserDTO requestUserDTO) {
        return new ResponseEntity<>(
                userService.addUser(requestUserDTO),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers() {
        return new ResponseEntity<>(
                userService.getAllUsers(),
                HttpStatus.OK
        );
    }
}
