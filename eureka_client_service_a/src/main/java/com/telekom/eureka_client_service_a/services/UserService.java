package com.telekom.eureka_client_service_a.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.telekom.eureka_client_service_a.model.UserAuth;
import com.telekom.eureka_client_service_a.repository.UserAuthRepository;

@Service
public class UserService {

    @Autowired
    private UserAuthRepository userRepository;

    public List<String> getAccesses(Authentication authentication) {
        UserAuth userAuth = userRepository.findByCredentialsLogin(authentication.getName());
        List<String> accesses = new ArrayList<>();
        userAuth.getRoles().stream().map(x -> {
            x.getAccesses().stream().forEach(y -> accesses.add(y.getAccessName()));
            return accesses;
        }).collect(Collectors.toList());
        return accesses;
    }
}
