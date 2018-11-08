package com.telekom.eureka_client_service_b.services;


import com.telekom.eureka_client_service_b.model.Product;
import com.telekom.eureka_client_service_b.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@PreAuthorize("hasRole('ROLE_USER') and hasPermission(returnObject,'ACCESSABLE_SERVICE_B')")
public class ServiceB {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AuthService authService;

    private List<Product> productsBucket = new ArrayList<>();

    @PostAuthorize("hasPermission(returnObject,'READONLY_SERVICE_B')")
    public List<Product> getAll() {
        restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(authService.getAuth().getUsername(), "pass"));
        return restTemplate.getForObject("http://eureka_client_a/service/A/products/all", List.class);
    }

    @PostAuthorize("hasPermission(returnObject,'READONLY_SERVICE_B')")
    public List<Product> getAllProductsInBucket() {
        return productsBucket;
    }

    @PostAuthorize("hasPermission(returnObject,'READONLY_SERVICE_B')")
    public void buyProduct(String product) {
        List<Product> products = getAll();
        List<Product> buyingProducts = products.stream().filter(x -> x.getProductName().equals(product)).collect(Collectors.toList());
        buyingProducts.forEach(buyingProduct -> productsBucket.add(buyingProduct));
    }
}
