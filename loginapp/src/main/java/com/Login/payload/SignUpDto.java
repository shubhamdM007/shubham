package com.Login.payload;

import lombok.Data;

@Data
public class SignUpDto {
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
}
