package com.dgmf.service;

import com.dgmf.dto.RequestUserDTO;
import com.dgmf.dto.ResponseUserDTO;
import com.dgmf.entity.User;

import java.util.List;

public interface UserService {
    ResponseUserDTO addUser(RequestUserDTO requestUserDTO);

    List<ResponseUserDTO> getAllUsers();
}
