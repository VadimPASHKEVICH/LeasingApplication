package com.leasing.security;

import com.leasing.domain.request.RegistrationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.net.http.HttpResponse;

@RestController
@RequestMapping(value = "/registration", produces = MediaType.APPLICATION_JSON_VALUE)
public class SecurityController {

    private final SecurityService securityService;

    @Autowired
    public SecurityController(SecurityService securityService) {
        this.securityService = securityService;
    }

    @PostMapping("/user")
    public ResponseEntity<HttpResponse> registrationUser(@RequestBody RegistrationUser registrationUser) {
        return new ResponseEntity<>(securityService.registrationUser(registrationUser) ? HttpStatus.CREATED : HttpStatus.CONFLICT);
    }
}
