package com.telekom.eureka_client_service_admin.controller;

import com.telekom.eureka_client_service_admin.exception.BusinessLogicException;
import com.telekom.eureka_client_service_admin.model.*;
import com.telekom.eureka_client_service_admin.service.impl.AdminServiceImpl;
import com.telekom.eureka_client_service_admin.utils.URLs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping(value = URLs.URL_API)
@CrossOrigin(origins = "*")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class RestAdminController {

    @Autowired
    private AdminServiceImpl adminService;

    @PostMapping(URLs.URL_POST_USER)
    public ResponseEntity<User> createUser(@RequestBody UserDTO userDTO) throws BusinessLogicException {
        User user = adminService.createUser(userDTO);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping(URLs.URL_DELETE_USER_BY_LOGIN)
    public HttpStatus deleteUserByLogin(@PathVariable String userName) throws BusinessLogicException {
        adminService.deleteUserByLogin(userName);
        return HttpStatus.OK;
    }

    @DeleteMapping(URLs.URL_DELETE_USER_BY_USERNAME)
    public HttpStatus deleteUserByName(@PathVariable String userName) throws BusinessLogicException {
        adminService.deleteUserByName(userName);
        return HttpStatus.OK;
    }

    @GetMapping(URLs.URL_GET_ACCESS)
    public ResponseEntity<List<Access>> getOpportunities() {
        List<Access> opportunities = adminService.getOpportunities();
        return ResponseEntity.ok(opportunities);
    }

    @PutMapping(URLs.URL_PUT_ACCESSES)
    public ResponseEntity<Role> grantOpportunities(@RequestBody GrantAccessDTO grantAccessDTO) throws BusinessLogicException {
        Role role = adminService.grantOpportunities(grantAccessDTO);
        return ResponseEntity.ok(role);
    }

    @GetMapping(URLs.URL_GET_USERS)
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = adminService.getUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping(URLs.URL_GET_USERS_USERNAME)
    public ResponseEntity<List<String>> getDetailInfo() {
        List<String> details = adminService.getDetail();
        return ResponseEntity.ok(details);
    }

    @GetMapping(URLs.URL_GET_USERS_LOGIN)
    public ResponseEntity<List<String>> getUserNames() {
        List<String> userNames = adminService.getCredentialsLogin();
        return ResponseEntity.ok(userNames);
    }

    @GetMapping(URLs.URL_GET_ROLES)
    public ResponseEntity<List<String>> getRoles() {
        List<String> roles = adminService.getRoles();
        return ResponseEntity.ok(roles);
    }

    @GetMapping(URLs.URL_GET_ACCESSES_BY_ROLE)
    public ResponseEntity<List<Access>> getOpportunitiesForRole(@PathVariable String role) throws BusinessLogicException {
        List<Access> opportunities = adminService.getAccessByRole(role);
        return ResponseEntity.ok(opportunities);
    }

    @GetMapping(URLs.URL_GET_SERVICES)
    public ResponseEntity<List<String>> getServices() {
        List<String> services = adminService.getServices();
        return ResponseEntity.ok(services);
    }

    @GetMapping(URLs.URL_GET_SERVICE_TYPES)
    public ResponseEntity<List<String>> getTypesAccess() {
        List<String> typesAccess = adminService.getTypesAccess();
        return ResponseEntity.ok(typesAccess);
    }

    @PostMapping(URLs.URL_POST_ACCESS)
    public ResponseEntity<Access> addAccess(@RequestBody AccessDTO accessDTO) throws BusinessLogicException {
        Access access = adminService.createAccess(accessDTO);
        return ResponseEntity.ok(access);
    }
}
