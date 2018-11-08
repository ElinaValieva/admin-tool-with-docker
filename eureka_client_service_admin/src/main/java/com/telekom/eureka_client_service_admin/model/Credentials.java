package com.telekom.eureka_client_service_admin.model;


import com.telekom.eureka_client_service_admin.configs.TableConfigs;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@Entity
@ToString
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
}
