package com.telekom.eureka_client_service_admin.service.impl;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.telekom.eureka_client_service_admin.exception.BusinessLogicException;
import com.telekom.eureka_client_service_admin.exception.ErrorCode;
import com.telekom.eureka_client_service_admin.model.*;
import com.telekom.eureka_client_service_admin.repository.*;
import com.telekom.eureka_client_service_admin.service.AdminService;
import com.telekom.eureka_client_service_admin.utils.Utils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private CredentialsRepository credentialsRepository;

    @Autowired
    private AccessRepository accessRepository;

    @Autowired
    private TypeAccessRepository typeAccessRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public User createUser(UserDTO userDTO) throws BusinessLogicException {
        User user = userRepository.findByCredentialsLogin(userDTO.getUserCredentialsLogin());

        if (userDTO.getUserRoles() == null)
            throw new BusinessLogicException(ErrorCode.EMPTY_ROLE.getMessage());

        if (userDTO.getUserCredentialsLogin().isEmpty() || userDTO.getUserCredentialsPassword().isEmpty() || userDTO.getUserUserName().isEmpty())
            throw new BusinessLogicException(ErrorCode.EMPTY_PARAMS.getMessage());

        if (user != null)
            throw new BusinessLogicException(ErrorCode.LOGIN_NOT_UNIQUE.getMessage());

        user = userRepository.findByName(userDTO.getUserUserName());

        if (user != null)
            throw new BusinessLogicException(ErrorCode.USERNAME_NOT_UNIQUE.getMessage());

        user = modelMapper.map(userDTO, User.class);
        Credentials credentials = new Credentials();
        credentials.setLogin(userDTO.getUserCredentialsLogin());
        credentials.setPassword(Utils.generatePassword(userDTO.getUserCredentialsPassword()));
        user.setCredentials(credentials);

        List<Role> roles = new ArrayList<>();
        userDTO.getUserRoles().stream().forEach(roleName -> {
            Role role = roleRepository.findByRole(roleName);
            if (role != null)
                roles.add(role);
        });
        user.setRoles(roles);
        Integer number = Utils.generateNumber();
        while (userRepository.findByUserNumber(number) != null)
            number = Utils.generateNumber();

        user.setUserNumber(number);
        credentialsRepository.save(credentials);
        userRepository.save(user);
        return user;
    }

    @Override
    public void deleteUserByLogin(String login) throws BusinessLogicException {
        User user = userRepository.findByCredentialsLogin(login);

        if (user == null)
            throw new BusinessLogicException(ErrorCode.USER_NOT_FOUND.getMessage());

        userRepository.delete(user);
    }

    @Override
    public void deleteUserByName(String name) throws BusinessLogicException {
        User user = userRepository.findByName(name);

        if (user == null)
            throw new BusinessLogicException(ErrorCode.USER_NOT_FOUND.getMessage());

        userRepository.delete(user);
    }

    @Override
    public List<Access> getOpportunities() {
        return (List<Access>) accessRepository.findAll();
    }

    @Override
    public Role grantOpportunities(GrantAccessDTO grantAccessDTO) throws BusinessLogicException {
        Role role = roleRepository.findByRole(grantAccessDTO.getRoleName());

        if (role == null)
            throw new BusinessLogicException(ErrorCode.USER_NOT_FOUND.getMessage());

        List<Access> opportunities = new ArrayList<>();

        grantAccessDTO.getAccesses().forEach(opportunityName -> {
            Access access = accessRepository.findByAccessName(opportunityName);
            if (access != null)
                opportunities.add(access);
        });

        role.setAccesses(opportunities);
        roleRepository.save(role);
        return role;
    }

    @Override
    public List<Access> getAccessByRole(String roleName) throws BusinessLogicException {
        Role role = roleRepository.findByRole(roleName);
        if (role == null)
            throw new BusinessLogicException(ErrorCode.EMPTY_PARAMS.getMessage());

        return role.getAccesses();
    }

    @Override
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }


    @Override
    public List<String> getCredentialsLogin() {
        return ((List<User>) userRepository.findAll())
                .stream()
                .map(User::getCredentials)
                .map(Credentials::getLogin)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getDetail() {
        return ((List<User>) userRepository.findAll())
                .stream()
                .map(User::getName)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getRoles() {
        return ((List<Role>) roleRepository.findAll())
                .stream()
                .map(Role::getRole)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getServices() {
        return ((List<TService>) serviceRepository.findAll())
                .stream()
                .map(TService::getService)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getTypesAccess() {
        return ((List<TypeAccess>) typeAccessRepository.findAll())
                .stream()
                .map(TypeAccess::getAccess)
                .collect(Collectors.toList());
    }

    @Override
    public Access createAccess(AccessDTO accessDTO) throws BusinessLogicException {
        TypeAccess typeAccess = typeAccessRepository.findByAccess(accessDTO.getTypeAccess());
        TService tService = serviceRepository.findByService(accessDTO.getNameService());
        String description = accessDTO.getNameAccess();

        if (typeAccess == null || tService == null)
            throw new BusinessLogicException(ErrorCode.EMPTY_PARAMS.getMessage());

        if (description == null || description == "" || description.isEmpty())
            description = typeAccess.getAccess() + " " + tService.getService();

        Access access = new Access();
        access.setAccessName(description);
        access.setTypeAccess(typeAccess);
        access.setTService(tService);
        accessRepository.save(access);

        return access;
    }
}
