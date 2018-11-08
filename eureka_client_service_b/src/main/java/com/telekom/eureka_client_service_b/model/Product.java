package com.telekom.eureka_client_service_b.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Product implements Serializable {

    private String productName;
    private String productPrice;
    private String productDescription;
}
