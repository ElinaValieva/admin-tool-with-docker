package com.telekom.eureka_client_service_admin.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
public class AccessDTO implements Serializable {

    String nameAccess;
    String nameService;
    String typeAccess;
}
