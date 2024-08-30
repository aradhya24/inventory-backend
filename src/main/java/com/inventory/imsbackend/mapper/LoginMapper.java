package com.inventory.imsbackend.mapper;

import com.inventory.imsbackend.dto.LoginDto;
import com.inventory.imsbackend.entity.Login;

public class LoginMapper {

    public static LoginDto mapToLoginDto(Login login){
        return new LoginDto(
           login.getId(), login.getUserName(),login.getEmail(), login.getPassword() , login.getUserType()
        );
    }

    public static Login mapToLogin(LoginDto login){
        return new Login(
                login.getId(), login.getUserName(),login.getEmail(), login.getPassword() , login.getUserType()
        );
    }

}
