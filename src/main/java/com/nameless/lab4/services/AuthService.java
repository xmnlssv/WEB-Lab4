package com.nameless.lab4.services;

import com.nameless.lab4.dto.JwtRequest;
import com.nameless.lab4.dto.JwtResponse;
import com.nameless.lab4.dto.RegistrationUser;
import com.nameless.lab4.dto.User;
import com.nameless.lab4.entities.UserEntity;
import com.nameless.lab4.exceptions.ApplicationError;
import com.nameless.lab4.utils.JwtToken;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserService userService;
    private final JwtToken jwtTokenUtils;
    private final AuthenticationManager authenticationManager;

    public ResponseEntity<?> createAuthToken(JwtRequest authRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authRequest.getUsername(),
                            authRequest.getPassword()));
        } catch (BadCredentialsException e) {
            return new ResponseEntity<>(
                    new ApplicationError(
                            HttpStatus.UNAUTHORIZED.value(),
                            "Неправильный логин или пароль"), HttpStatus.UNAUTHORIZED);
        }
        UserDetails userDetails = userService.loadUserByUsername(authRequest.getUsername());
        String token = jwtTokenUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    public ResponseEntity<?> createNewUser(RegistrationUser registrationUser) {
        if (userService.findByUsername(registrationUser.getUsername()).isPresent()) {
            return new ResponseEntity<>(
                    new ApplicationError(
                            HttpStatus.BAD_REQUEST.value(),
                            "Пользователь с указанным именем уже существует"), HttpStatus.BAD_REQUEST);
        }
        UserEntity userEntity = userService.createNewUser(registrationUser);
        return ResponseEntity.ok(new User(userEntity.getId(), userEntity.getUsername()));
    }
}