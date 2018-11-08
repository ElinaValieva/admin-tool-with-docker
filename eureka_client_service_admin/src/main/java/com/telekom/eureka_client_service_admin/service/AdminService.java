package com.telekom.eureka_client_service_admin.service;


import com.telekom.eureka_client_service_admin.exception.BusinessLogicException;
import com.telekom.eureka_client_service_admin.model.*;


import java.util.List;

public interface AdminService {

    User createUser(UserDTO userDTO) throws BusinessLogicException;

    void deleteUserByLogin(String login) throws BusinessLogicException;

    void deleteUserByName(String name) throws BusinessLogicException;

    List<Access> getOpportunities();

    List<User> getUsers();

    List<String> getCredentialsLogin();

    List<String> getDetail();

    List<String> getRoles();

    List<String> getServices();

    List<String> getTypesAccess();

    Access createAccess(AccessDTO accessDTO) throws BusinessLogicException;

    Role grantOpportunities(GrantAccessDTO grantAccessDTO) throws BusinessLogicException;

    List<Access> getAccessByRole(String role) throws BusinessLogicException;
}
