package com.leasing.controller;

import com.leasing.domain.AgreementInfo;
import com.leasing.service.AgreementInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping(name = "/info", produces = MediaType.APPLICATION_JSON_VALUE)
public class AgreementInfoController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    AgreementInfoService agreementInfoService;

    @Autowired
    public AgreementInfoController(AgreementInfoService agreementInfoService) {
        this.agreementInfoService = agreementInfoService;
    }

    @PostMapping("/createInfo")
    public ResponseEntity<HttpStatus> createAgInfo(@RequestBody @Valid AgreementInfo agreementInfo, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            for (ObjectError o : bindingResult.getAllErrors()) {
                log.warn(o.getDefaultMessage());
            }
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        agreementInfoService.createAgInfo(agreementInfo);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/updateInfo")
    public ResponseEntity<HttpStatus> updateAgInfo(@RequestBody @Valid AgreementInfo agreementInfo, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            for (ObjectError o : bindingResult.getAllErrors()) {
                log.warn(o.getDefaultMessage());
            }
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        agreementInfoService.updateAgInfo(agreementInfo);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/allInfo")
    public ResponseEntity<ArrayList<AgreementInfo>> getAllAgInfo() {
        if (agreementInfoService.getAllAgInfo() != null) {
            return new ResponseEntity<>(agreementInfoService.getAllAgInfo(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgreementInfo> getAgInfoById(@PathVariable int id) {
        AgreementInfo agreementInfo = agreementInfoService.getAgInfoById(id);
        return new ResponseEntity<>(agreementInfo, agreementInfo.getId() != 0 ? HttpStatus.OK : HttpStatus.CONFLICT);
    }

    @DeleteMapping("/deleteAgInfo")
    public ResponseEntity<HttpStatus> delete(@RequestBody @Valid AgreementInfo agreementInfo, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            for (ObjectError o : bindingResult.getAllErrors()){
                log.warn(o.getDefaultMessage());
            }
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        agreementInfoService.deleteAgInfo(agreementInfo);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
