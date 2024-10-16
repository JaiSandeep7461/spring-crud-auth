package com.example.jwtdemo.controllers;

import com.example.jwtdemo.dtos.LoginUserDto;
import com.example.jwtdemo.dtos.RegisterUserDto;
import com.example.jwtdemo.entities.User;
import com.example.jwtdemo.models.LoginResponse;
import com.example.jwtdemo.services.AuthenticationService;
import com.example.jwtdemo.services.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {

    private final JwtService jwtService;

    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody RegisterUserDto registerUserDto) {
        User registeredUser = authenticationService.signup(registerUserDto);

        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) {
        System.out.println("The Request Data>>> "+loginUserDto.getEmail());
        User authenticatedUser = authenticationService.authenticate(loginUserDto);
        System.out.println("The route>>> "+authenticatedUser.getUsername().length());
        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }

}
