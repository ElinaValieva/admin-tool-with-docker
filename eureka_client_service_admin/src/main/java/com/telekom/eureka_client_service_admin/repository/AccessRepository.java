package com.telekom.eureka_client_service_admin.repository;


import com.telekom.eureka_client_service_admin.model.Access;
import org.springframework.data.repository.CrudRepository;



public interface AccessRepository extends CrudRepository<Access, Long> {

    Access findByAccessName(String accessName);
}
