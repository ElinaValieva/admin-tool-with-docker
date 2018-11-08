package com.telekom.eureka_client_service_admin.repository;


import com.telekom.eureka_client_service_admin.model.TypeAccess;
import org.springframework.data.repository.CrudRepository;

public interface TypeAccessRepository extends CrudRepository<TypeAccess, Long> {

    TypeAccess findByAccess(String accessName);
}
