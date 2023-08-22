package com.dgmf.service;

import com.dgmf.dto.RequestUserDTO;
import com.dgmf.dto.ResponseUserDTO;

public interface UserService {
    ResponseUserDTO addUser(RequestUserDTO requestUserDTO);
}
