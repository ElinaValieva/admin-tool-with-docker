package com.telekom.eureka_client_service_a.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.telekom.eureka_client_service_a.model.Product;

@Service
@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN') and hasPermission(returnObject,'ACCESSABLE_SERVICE_A')")
public class ServiceA {

    List<Product> products;

    ServiceA(){
        products = new ArrayList<>();
        Product product = new Product();
        product.setProductName("test");
        product.setProductPrice("$500");
        product.setProductDescription("test product");
        products.add(product);
    }

    @PostAuthorize("hasPermission(returnObject,'READONLY_SERVICE_A')")
    public String getServiceName() {
        return this.getClass().getName();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') and hasPermission(returnObject,'READONLY_SERVICE_A')")
    public Object getUserInfo() {
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    @PostAuthorize("hasPermission(returnObject,'READONLY_SERVICE_A')")
    public List<Product> getAll() {
        return products;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') and hasPermission(returnObject,'READWRITE_SERVICE_A')")
    public void add(Product product) {
        products.add(product);
    }

    public void remove(String product) {
        List<Product> productsForDeleting = products.stream().filter(x->x.getProductName().equals(product)).collect(Collectors.toList());
        productsForDeleting.forEach(productDeleting -> products.remove(productDeleting));
    }
}
