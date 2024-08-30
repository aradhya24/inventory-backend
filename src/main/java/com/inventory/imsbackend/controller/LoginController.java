package com.inventory.imsbackend.controller;

import com.inventory.imsbackend.dto.LoginDto;
import com.inventory.imsbackend.services.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController //handles the http req
@RequestMapping("/api/login")
public class LoginController {

    private LoginService loginService;

    //Build add login REST API
    @PostMapping
    public ResponseEntity<LoginDto> createLogin (@RequestBody LoginDto loginDto){
        LoginDto savedLogin = loginService.createLogin(loginDto);
        return new ResponseEntity<>(savedLogin , HttpStatus.CREATED);
    }

    //Build get login REST API
    @GetMapping("{id}")
    public ResponseEntity<LoginDto> getLoginById(@PathVariable("id") long id){
        LoginDto loginDto = loginService.getLoginById(id);
        return ResponseEntity.ok(loginDto);
    }



}
