package com.leasing.service;

import com.leasing.domain.CreditCard;
import com.leasing.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditCardService {
    CreditCardRepository creditCardRepository;

    @Autowired
    public CreditCardService(CreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }

    public void createCard(CreditCard card) {
        creditCardRepository.save(card);
    }

    public void updateCard(CreditCard card) {
        creditCardRepository.saveAndFlush(card);
    }

    public void deleteCard(CreditCard card) {
        creditCardRepository.delete(card);
    }
}
