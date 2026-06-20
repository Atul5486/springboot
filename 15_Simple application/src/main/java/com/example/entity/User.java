package com.example.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name="simple_user")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column
    String name;
    @Column
    String email;
    @Column
    String password;

}
