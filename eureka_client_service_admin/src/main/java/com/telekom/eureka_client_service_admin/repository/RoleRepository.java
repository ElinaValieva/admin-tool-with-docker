package com.telekom.eureka_client_service_admin.repository;


import com.telekom.eureka_client_service_admin.model.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {

    Role findByRole(String role);
}
