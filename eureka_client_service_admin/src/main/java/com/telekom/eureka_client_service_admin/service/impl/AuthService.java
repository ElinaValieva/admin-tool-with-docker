package com.telekom.eureka_client_service_admin.service.impl;



import com.telekom.eureka_client_service_admin.model.Role;
import com.telekom.eureka_client_service_admin.model.User;
import com.telekom.eureka_client_service_admin.repository.RoleRepository;
import com.telekom.eureka_client_service_admin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByCredentialsLogin(username);
        Role admin = roleRepository.findByRole("ROLE_ADMIN");
        boolean adminConditional = user.getRoles().stream().filter(x -> x.getId() == admin.getId()).findAny().isPresent();
        if (adminConditional) {
            Collection<GrantedAuthority> authorities = user.getRoles()
                    .stream()
                    .map(userRole -> new SimpleGrantedAuthority(userRole.getRole()))
                    .collect(Collectors.toCollection(ArrayList::new));
            return new org.springframework.security.core.userdetails
                    .User(username, user.getCredentials().getPassword(), true, true, true, true, authorities);
        } else throw new UsernameNotFoundException("User not found!");
    }
}