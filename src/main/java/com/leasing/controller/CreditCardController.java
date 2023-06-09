package com.leasing.controller;

import com.leasing.domain.CreditCard;
import com.leasing.service.CreditCardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/card", produces = MediaType.APPLICATION_JSON_VALUE)
public class CreditCardController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final CreditCardService cardService;

    @Autowired
    public CreditCardController(CreditCardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping("/createCard")
    public ResponseEntity<HttpStatus> createCard(@RequestBody @Valid CreditCard card, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            for (ObjectError o : bindingResult.getAllErrors()) {
                log.warn(o.getDefaultMessage());
            }
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        cardService.createCard(card);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/updateCard")
    public ResponseEntity<HttpStatus> updateCard(@RequestBody @Valid CreditCard card, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            for (ObjectError o : bindingResult.getAllErrors()) {
                log.warn(o.getDefaultMessage());
            }
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        cardService.updateCard(card);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/deleteCard/{id}")
    public ResponseEntity<HttpStatus> deleteCard(@PathVariable int id) {
        try {
            if (cardService.deleteCard(id)) {
                return new ResponseEntity<>(HttpStatus.OK);
            }
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
}