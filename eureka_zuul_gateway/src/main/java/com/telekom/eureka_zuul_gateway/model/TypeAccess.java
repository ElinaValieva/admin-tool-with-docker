package com.telekom.eureka_zuul_gateway.model;


import com.telekom.eureka_zuul_gateway.configs.TableConfigs;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = TableConfigs.TABLE_TYPE_ACCESS, schema = TableConfigs.SCHEMA)
public class TypeAccess {

    @Id
    @SequenceGenerator(name = TableConfigs.GENERATOR,
            sequenceName = TableConfigs.TABLE_TYPE_ACCESS_SEQUENCE,
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = TableConfigs.GENERATOR)
    @Column(name = TableConfigs.TABLE_TYPE_ACCESS_ID)
    private Long id;

    @Column(name = TableConfigs.TABLE_TYPE_ACCESS_NAME)
    private String access;
}
