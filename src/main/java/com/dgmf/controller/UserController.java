package com.dgmf.controller;

import com.dgmf.dto.RequestUserDTO;
import com.dgmf.dto.ResponseUserDTO;
import com.dgmf.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody RequestUserDTO requestUserDTO) {
        // userService.addUser(requestUserDTO);

        return new ResponseEntity<>(
                userService.addUser(requestUserDTO),
                HttpStatus.CREATED)
                ;
    }
}
