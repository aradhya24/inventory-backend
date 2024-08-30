package com.inventory.imsbackend.services.impl;

import com.inventory.imsbackend.dto.LoginDto;
import com.inventory.imsbackend.entity.Inventory;
import com.inventory.imsbackend.entity.Login;
import com.inventory.imsbackend.exception.ResourceNotFoundException;
import com.inventory.imsbackend.mapper.InventoryMapper;
import com.inventory.imsbackend.mapper.LoginMapper;
import com.inventory.imsbackend.repository.LoginRepository;
import com.inventory.imsbackend.services.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class LoginServiceImpl implements LoginService {

    private LoginRepository loginRepository;
    @Override
    public LoginDto createLogin(LoginDto loginDto) {

        Login login = LoginMapper.mapToLogin(loginDto);
        Login savedLogin = loginRepository.save(login);
        return LoginMapper.mapToLoginDto(savedLogin);
    }

    @Override
    public LoginDto getLoginById(long id) {
        Login login = loginRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not exist by given ID : "+ id));
        return LoginMapper.mapToLoginDto(login);
    }

    @Override
    public List<LoginDto> getAllLogin() {
        List<Login> logins = loginRepository.findAll();
        return logins.stream().map((login)-> LoginMapper.mapToLoginDto(login))
                .collect(Collectors.toList());
    }

    @Override
    public LoginDto updateLogin(long id, LoginDto loginDto) {
        Login login = loginRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Inventory Not Exist by Given ID" + id)) ;

        login.setUserName(loginDto.getUserName());
        login.setPassword(loginDto.getPassword());
        Login updatedLoginObj = loginRepository.save(login);

        return LoginMapper.mapToLoginDto(updatedLoginObj);
    }

    @Override
    public void deleteLoginById(long id) {
        Login login = loginRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Inventory not exist by Id : " + id));
        loginRepository.deleteById(id);
    }
}
