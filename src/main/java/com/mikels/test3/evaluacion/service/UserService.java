package com.mikels.test3.evaluacion.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.mikels.test3.evaluacion.models.User;
import com.mikels.test3.evaluacion.models.requests.UserLoginRequest;
import com.mikels.test3.evaluacion.models.requests.UserSignUpRequest;
import com.mikels.test3.evaluacion.repository.UserRepository;
import com.mikels.test3.evaluacion.util.JwtUtil;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    public String authenticateUser(UserLoginRequest loginRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        } catch (BadCredentialsException e) {
            return null;
        }
        final UserDetails userDetails = userRepository.loadUserByUsername(loginRequest.getUsername());
        return jwtUtil.generateToken(userDetails.getUsername());
    }

    public void createUser(UserSignUpRequest signUpRequest) {
        User user = new User();
        user.setUsername(signUpRequest.getUsername());
        user.setPassword(signUpRequest.getPassword()); // Esto debería ser hasheado y no almacenado en texto plano
        userRepository.save(user);
    }

    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }
}
