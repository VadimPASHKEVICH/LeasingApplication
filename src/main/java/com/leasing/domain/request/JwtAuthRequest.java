package com.leasing.domain.request;
import lombok.Data;

@Data
public class JwtAuthRequest {
    private String login;
    private String password;
}
