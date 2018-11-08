package com.telekom.eureka_client_service_b.model;

import com.telekom.eureka_client_service_b.configs.TableConfigs;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


/**
 * Some moments:
 *      Hibernate can generate negative primary key, so to solve this issue is necessary to use allocationSize
 *      In some version of postgres hibernate can't use generator sequence automatically, so we declare sequence generator
 *      If you want to declare start index, use initialValue property in @SequenceGenerator
 */
@Getter
@Setter
@Entity
@Table(name = TableConfigs.TABLE_USER_DETAIL, schema = TableConfigs.SCHEMA)
public class User {

    @Id
    @SequenceGenerator(name = TableConfigs.GENERATOR,
            sequenceName = TableConfigs.TABLE_USER_DETAIL_SEQUENCE, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = TableConfigs.GENERATOR)
    @Column(name = TableConfigs.TABLE_USER_DETAIL_COLUMN_ID)
    private Long id;

    @Column(name = TableConfigs.TABLE_USER_DETAIL_COLUMN_NAME)
    private String name;

    @Column(name = TableConfigs.TABLE_USER_DETAIL_COLUMN_NUMBER)
    private Integer userNumber;

    @OneToOne
    private Credentials credentials;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = TableConfigs.TABLE_USER_DETAIL_ROLE,
            joinColumns = {
                    @JoinColumn(name = TableConfigs.TABLE_USER_DETAIL_ROLE_COLUMN_USER_DETAIL)},
            inverseJoinColumns = {
                    @JoinColumn(name = TableConfigs.TABLE_USER_DETAIL_ROLE_COLUMN_ROLE)})
    private List<Role> roles;
}
