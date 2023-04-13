package com.leasing.domain;

import lombok.Data;
import javax.persistence.*;
import javax.persistence.Entity;

@Data
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_seq")
    @SequenceGenerator(name = "role_seq", sequenceName = "roles_id_seq", allocationSize = 1)
    private int id;
    @Column(name = "user_id")
    private int userId;
    @Column(name = "user_role")
    private String userRole;
}
