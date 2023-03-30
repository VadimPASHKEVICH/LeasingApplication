package com.leasing.controller;

import com.leasing.domain.Agreement;
import com.leasing.domain.User;
import com.leasing.service.AgreementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/agreement", produces = MediaType.APPLICATION_JSON_VALUE)
public class AgreementController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final AgreementService agreementService;
    @Autowired
    public AgreementController(AgreementService agreementService) {
        this.agreementService = agreementService;
    }
    @PostMapping
    public ResponseEntity<HttpStatus> createAgreement(@RequestBody Agreement agreement, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            for (ObjectError o : bindingResult.getAllErrors()) {
                log.warn(o.getDefaultMessage());
            }
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        agreementService.createAgreement(agreement);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping
    public ResponseEntity<HttpStatus> updateAgreement(@RequestBody Agreement agreement, BindingResult bindingResult ) {
        if (bindingResult.hasErrors()) {
            for (ObjectError o : bindingResult.getAllErrors()) {
                log.warn(o.getDefaultMessage());
            }
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        agreementService.updateAgreement(agreement);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping
    public ResponseEntity<ArrayList<Agreement>> getAllAgreements() {
        return new ResponseEntity<>(agreementService.getAllAgreements(), HttpStatus.OK);
    }
    @GetMapping("{/id}")
    public ResponseEntity<Agreement> getAgreementById(@PathVariable int id){
        Agreement agreement = agreementService.getAgreementById(id);
        return new ResponseEntity<>(agreement, agreement.getId() != 0 ? HttpStatus.OK : HttpStatus.CONFLICT);
    }
    @DeleteMapping
    public ResponseEntity<HttpStatus> delete(@RequestBody Agreement agreement) {
        agreementService.deleteAgreement(agreement);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
