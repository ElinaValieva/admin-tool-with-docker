package com.telekom.eureka_client_service_a.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.telekom.eureka_client_service_a.configs.TableConfigs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = TableConfigs.TABLE_ACCESS, schema = TableConfigs.SCHEMA)
public class Access {

    @Id
    @SequenceGenerator(name = TableConfigs.GENERATOR,
            sequenceName = TableConfigs.TABLE_ACCESS_SEQUENCE,
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = TableConfigs.GENERATOR)
    @Column(name = TableConfigs.TABLE_ACCESS_COLUMN_ID)
    private Long id;

    @Column(name = TableConfigs.TABLE_ACCESS_COLUMN_NAME)
    private String accessName;

    @OneToOne
    private TypeAccess typeAccess;

    @OneToOne
    private TService tService;
    
    public String getAccessName() {
        return accessName;
    }
}
