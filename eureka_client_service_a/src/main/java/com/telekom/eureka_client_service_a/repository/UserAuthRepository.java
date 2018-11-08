package com.telekom.eureka_client_service_a.repository;


import com.telekom.eureka_client_service_a.model.*;

import org.springframework.data.repository.CrudRepository;

public interface UserAuthRepository extends CrudRepository<UserAuth, Long> {

    UserAuth findByCredentialsLogin(String login);
}
