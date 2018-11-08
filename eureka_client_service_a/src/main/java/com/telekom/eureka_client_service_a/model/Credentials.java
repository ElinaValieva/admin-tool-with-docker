package com.telekom.eureka_client_service_a.model;



import com.telekom.eureka_client_service_a.configs.TableConfigs;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = TableConfigs.TABLE_CREDENTIALS, schema = TableConfigs.SCHEMA)
public class Credentials {

    @Id
    @SequenceGenerator(name = TableConfigs.GENERATOR,
            sequenceName = TableConfigs.TABLE_CREDENTIALS_SEQUENCE,
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = TableConfigs.GENERATOR)
    @Column(name = TableConfigs.TABLE_CREDENTIALS_COLUMN_ID)
    private Long id;

    @Column(name = TableConfigs.TABLE_CREDENTIALS_COLUMN_LOGIN)
    private String login;

    @Column(name = TableConfigs.TABLE_CREDENTIALS_COLUMN_PASS)
    private String password;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
