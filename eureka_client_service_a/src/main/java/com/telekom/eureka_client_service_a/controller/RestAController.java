package com.telekom.eureka_client_service_a.controller;

import com.telekom.eureka_client_service_a.configs.utils.URLs;
import com.telekom.eureka_client_service_a.model.Product;
import com.telekom.eureka_client_service_a.services.ServiceA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = URLs.URL_API)
@CrossOrigin(origins = "*")
@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
public class RestAController {

    @Autowired
    private ServiceA serviceA;

    @GetMapping(URLs.URL_GET_SERVICE_NAME)
    public ResponseEntity<String> getServiceName() {
        return ResponseEntity.ok(serviceA.getServiceName());
    }

    @GetMapping(URLs.URL_GET_AUTH)
    public ResponseEntity<Object> getPrincipal() {
        return ResponseEntity.ok(serviceA.getUserInfo());
    }

    @GetMapping(URLs.URL_GET_ALL_PRODUCTS)
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(serviceA.getAll());
    }

    @PostMapping(URLs.URL_POST_PRODUCT)
    public HttpStatus addProduct(@RequestBody Product product) {
        serviceA.add(product);
        return HttpStatus.OK;
    }

    @DeleteMapping(URLs.URL_DELETE_PRODUCT_BY_ID)
    public HttpStatus removeProduct(@PathVariable String product) {
        serviceA.remove(product);
        return HttpStatus.OK;
    }

    @GetMapping(URLs.URL_TEST_MESSAGE)
    public String test() {
        return "Hello from service A";
    }
}
