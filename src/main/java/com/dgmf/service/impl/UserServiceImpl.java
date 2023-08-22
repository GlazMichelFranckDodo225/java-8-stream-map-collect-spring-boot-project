package com.dgmf.service.impl;

import com.dgmf.dto.RequestUserDTO;
import com.dgmf.dto.ResponseUserDTO;
import com.dgmf.entity.User;
import com.dgmf.repository.UserRepository;
import com.dgmf.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final List<ResponseUserDTO> responseUserDTOS;

    @Override
    public ResponseUserDTO addUser(RequestUserDTO requestUserDTO) {
        User user = User.builder()
                .username(requestUserDTO.getUsername())
                .email(requestUserDTO.getEmail())
                .password(requestUserDTO.getPassword())
                .build();

        userRepository.save(user);

        User savedUser = userRepository.findById(user.getId()).orElseThrow(
                () -> new RuntimeException("Error occurred while adding User")
        );

        ResponseUserDTO returnedResponseUserDTO = ResponseUserDTO.builder()
                .id(savedUser.getId())
                .username(savedUser.getUsername())
                .email(savedUser.getEmail())
                .build();

        return returnedResponseUserDTO;
    }

    @Override
    public List<ResponseUserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();

        for(User user: users) {
            ResponseUserDTO responseUserDTO = ResponseUserDTO.builder()
                    .id(user.getId())
                    .username(user.getUsername())
                    .email(user.getEmail())
                    .build();

            responseUserDTOS.add(responseUserDTO);
        }

        return responseUserDTOS;
    }
}
