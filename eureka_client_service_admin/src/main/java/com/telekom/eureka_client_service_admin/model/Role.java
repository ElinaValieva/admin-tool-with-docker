package com.telekom.eureka_client_service_admin.model;


import com.telekom.eureka_client_service_admin.configs.TableConfigs;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@EqualsAndHashCode
@ToString
@Table(name = TableConfigs.TABLE_ROLE, schema = TableConfigs.SCHEMA)
public class Role {

    @Id
    @SequenceGenerator(name = TableConfigs.GENERATOR,
            sequenceName = TableConfigs.TABLE_ROLE_SEQUENCE,
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = TableConfigs.GENERATOR)
    @Column(name = TableConfigs.TABLE_ROLE_ID)
    private Long id;

    @Column(name = TableConfigs.TABLE_ROLE_NAME)
    private String role;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = TableConfigs.TABLE_ROLE_ACCESS ,
            joinColumns = {
                    @JoinColumn(name = TableConfigs.TABLE_ROLE_ACCESS_COLUMN_USER_DETAIL)},
            inverseJoinColumns = {
                    @JoinColumn(name = TableConfigs.TABLE_ROLE_ACCESS_COLUMN_OPPORTUNITY)})
    private List<Access> accesses;
}
