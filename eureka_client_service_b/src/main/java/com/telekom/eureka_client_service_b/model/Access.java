package com.telekom.eureka_client_service_b.model;



import com.telekom.eureka_client_service_b.configs.TableConfigs;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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
}
