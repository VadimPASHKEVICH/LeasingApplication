package com.leasing.domain.request;
import lombok.Data;

@Data
public class RegistrationUser {
    private String firstName;
    private String lastName;
    private String login;
    private String password;
}
