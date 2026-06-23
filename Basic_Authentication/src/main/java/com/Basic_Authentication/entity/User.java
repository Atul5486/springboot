package com.Basic_Authentication.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="user_basic")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column
    String username;

    @Column
    String role;

    @Column
    String password;

    @Column
    boolean active;

}
