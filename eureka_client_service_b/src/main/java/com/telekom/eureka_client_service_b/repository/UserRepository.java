package com.telekom.eureka_client_service_b.repository;


import com.telekom.eureka_client_service_b.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByCredentialsLogin(String login);
}
