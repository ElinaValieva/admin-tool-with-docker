package com.telekom.eureka_client_service_b.repository;


import com.telekom.eureka_client_service_b.model.Credentials;
import org.springframework.data.repository.CrudRepository;

public interface CredentialsRepository extends CrudRepository<Credentials, Long> {
}
