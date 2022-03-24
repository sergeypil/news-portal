package com.epam.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="C##ADMIN.\"role\"")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private List<User> users;
}
