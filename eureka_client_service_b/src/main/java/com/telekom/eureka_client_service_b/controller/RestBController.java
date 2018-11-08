package com.telekom.eureka_client_service_b.controller;


import com.telekom.eureka_client_service_b.model.Product;
import com.telekom.eureka_client_service_b.services.ServiceB;
import com.telekom.eureka_client_service_b.utils.URLs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = URLs.URL_SERVICE_B_API)
public class RestBController {

    @Autowired
    private ServiceB serviceB;

    @GetMapping(value = URLs.URL_GET_ALL_PRODUCTS)
    public ResponseEntity<List<Product>> getAllProductsForBuying() {
        return ResponseEntity.ok(serviceB.getAll());
    }

    @PutMapping(value = URLs.URL_PUT_ADD_PRODUCT)
    public HttpStatus buyProduct(@PathVariable String product) {
        serviceB.buyProduct(product);
        return HttpStatus.OK;
    }

    @GetMapping(value = URLs.URL_GET_ALL_PRODUCT_FROM_BUCKET)
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(serviceB.getAllProductsInBucket());
    }
}
