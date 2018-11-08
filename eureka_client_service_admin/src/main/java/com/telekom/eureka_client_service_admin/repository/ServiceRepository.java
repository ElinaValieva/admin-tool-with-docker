package com.telekom.eureka_client_service_admin.repository;


import com.telekom.eureka_client_service_admin.model.TService;
import org.springframework.data.repository.CrudRepository;

public interface ServiceRepository extends CrudRepository<TService, Long> {

    TService findByService(String serviceName);
}
