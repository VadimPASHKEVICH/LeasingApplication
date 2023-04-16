package com.leasing.service;

import com.leasing.domain.CreditCard;
import com.leasing.domain.User;
import com.leasing.exception.CardException;
import com.leasing.repository.CreditCardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CreditCardService {
    private final CreditCardRepository creditCardRepository;
    private final UserService userService;
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public CreditCardService(CreditCardRepository creditCardRepository, UserService userService) {
        this.creditCardRepository = creditCardRepository;
        this.userService = userService;
    }

    public void createCard(CreditCard card) {
        creditCardRepository.save(card);
    }

    public void updateCard(CreditCard card) {
        creditCardRepository.saveAndFlush(card);
    }

    public boolean deleteCard(int id) {
        try {
            User user = userService.getUserByLogin();
            ArrayList<CreditCard> creditCards = creditCardRepository.getCreditCardByUserId(user.getId());
            for (CreditCard creditCard : creditCards) {
                if (creditCard.getId() == id) {
                    creditCardRepository.deleteById(creditCard.getId());
                    return true;
                }
            }
            throw new CardException("You don't have this card");
        } catch (CardException e) {
            log.error(e.getMessage());
            return false;
        }
    }
}
