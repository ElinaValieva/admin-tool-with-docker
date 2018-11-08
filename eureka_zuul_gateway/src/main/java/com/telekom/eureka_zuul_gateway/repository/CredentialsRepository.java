package com.telekom.eureka_zuul_gateway.repository;


import com.telekom.eureka_zuul_gateway.model.Credentials;
import org.springframework.data.repository.CrudRepository;

public interface CredentialsRepository extends CrudRepository<Credentials, Long> {
}
