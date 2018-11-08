package com.telekom.eureka_zuul_gateway.repository;



import com.telekom.eureka_zuul_gateway.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByCredentialsLogin(String login);
}
