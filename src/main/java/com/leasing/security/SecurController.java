package com.leasing.security;

import com.leasing.domain.request.RegistrationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;

@RestController
public class SecurController {

    SecurityService securityService;
    @Autowired
    public SecurController(SecurityService securityService) {
        this.securityService = securityService;
    }

    @PostMapping("/registration")
    public ResponseEntity <HttpResponse> registrationUser(@RequestBody RegistrationUser registrationUser){
        return new ResponseEntity<>(securityService.registration(registrationUser) ? HttpStatus.CREATED : HttpStatus.CONFLICT);
    }
}
