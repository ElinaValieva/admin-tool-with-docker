package com.telekom.eureka_client_service_admin.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO implements Serializable {

    private String userUserName;
    private String userCredentialsLogin;
    private String userCredentialsPassword;
    private List<String> userRoles;
}
