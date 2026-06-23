package com.Basic_Authentication.dto;

import lombok.Data;

@Data
public class UserDto {

    String username;

    String role;

    String password;

    boolean active;

}
