package com.telekom.eureka_client_service_a.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import com.telekom.eureka_client_service_a.model.UserAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.telekom.eureka_client_service_a.repository.UserAuthRepository;

@Service
public class AuthService implements UserDetailsService{
	
	@Autowired
    private UserAuthRepository userRepository;

    public UserDetails loadUserByUsername(String username) {
        UserAuth userAuth = userRepository.findByCredentialsLogin(username);
        if (userAuth != null) {
            Collection<GrantedAuthority> authorities = userAuth.getRoles()
                    .stream()
                    .map(userRole -> new SimpleGrantedAuthority(userRole.getRole()))
                    .collect(Collectors.toCollection(ArrayList::new));
            return new org.springframework.security.core.userdetails
                    .User(username, userAuth.getCredentials().getPassword(), true, true, true, true, authorities);
        } else throw new UsernameNotFoundException("UserAuth not found!");
    }
}
