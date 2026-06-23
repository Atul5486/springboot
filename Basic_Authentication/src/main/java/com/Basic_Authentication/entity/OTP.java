package com.Basic_Authentication.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="otp")
@Data
public class OTP {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column
    String username;

    @Column
    String otp;

}
