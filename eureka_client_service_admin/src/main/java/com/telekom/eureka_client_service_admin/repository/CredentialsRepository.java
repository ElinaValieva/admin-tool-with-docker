package com.telekom.eureka_client_service_admin.repository;



import com.telekom.eureka_client_service_admin.model.Credentials;
import org.springframework.data.repository.CrudRepository;

public interface CredentialsRepository extends CrudRepository<Credentials, Long> {
}
