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
@Table(name = TableConfigs.TABLE_SERVICE, schema = TableConfigs.SCHEMA)
public class TService {

    @Id
    @SequenceGenerator(name = TableConfigs.GENERATOR,
            sequenceName = TableConfigs.TABLE_SERVICE_SEQUENCE,
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = TableConfigs.GENERATOR)
    @Column(name = TableConfigs.TABLE_SERVICE_ID)
    private Long id;

    @Column(name = TableConfigs.TABLE_SERVICE_NAME)
    private String service;
}

