package com.telekom.eureka_client_service_admin.repository;


import com.telekom.eureka_client_service_admin.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByCredentialsLogin(String login);

    User findByUserNumber(int number);

    User findByName(String name);
}
