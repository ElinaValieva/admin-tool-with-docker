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
