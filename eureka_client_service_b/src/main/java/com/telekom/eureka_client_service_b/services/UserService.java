package com.telekom.eureka_client_service_b.services;

import com.telekom.eureka_client_service_b.model.User;
import com.telekom.eureka_client_service_b.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<String> getAccesses(Authentication authentication) {
        User user = userRepository.findByCredentialsLogin(authentication.getName());

        List<String> accesses = new ArrayList<>();
        user.getRoles().stream().map(x -> {
            x.getAccesses().stream().forEach(y -> accesses.add(y.getAccessName()));
            return accesses;
        }).collect(Collectors.toList());
        return accesses;
    }
}
