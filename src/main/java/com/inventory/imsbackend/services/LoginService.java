package com.inventory.imsbackend.services;

import com.inventory.imsbackend.dto.InventoryDto;
import com.inventory.imsbackend.dto.LoginDto;

import java.util.List;

public interface LoginService {
    LoginDto createLogin(LoginDto loginDto);
    LoginDto getLoginById(long id);
    List<LoginDto> getAllLogin();
    LoginDto updateLogin(long id , LoginDto loginDto);
    void deleteLoginById(long id);
}
