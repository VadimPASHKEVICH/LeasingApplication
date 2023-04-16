package service;

import com.leasing.domain.Agreement;
import com.leasing.domain.CreditCard;
import com.leasing.repository.CreditCardRepository;
import com.leasing.service.AgreementService;
import com.leasing.service.CreditCardService;
import com.leasing.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreditCardServiceTest {
    @Mock
    private CreditCardRepository creditCardRepository;

    private UserService userService;

    private CreditCardService creditCardService;

    private CreditCard creditCard;

    private List<CreditCard> creditCards;

    @BeforeEach
    void setCreditCard() {
        MockitoAnnotations.openMocks(this);
        creditCardService = new CreditCardService(creditCardRepository, userService);
        creditCard = new CreditCard(1, "1111 2222 3333 4444", "MasterCard", "09/26", 101, 2);
        creditCards = new ArrayList<>();
        creditCards.add(creditCard);
        creditCardRepository.save(creditCard);
    }
    @Test
    void createCard(){
        creditCardService = new CreditCardService(creditCardRepository, userService);
        creditCard = new CreditCard(2,"0000111122223333", "VISA", "02.02.2025", 001, 1);
    }

    @Test
    void deleteCard() {
        creditCardService = new CreditCardService(creditCardRepository, userService);
        creditCard = new CreditCard(2,"0000111122223333", "VISA", "02.02.2025", 001, 3);
    }
    @Test
    void updateCard(){
        creditCardService = new CreditCardService(creditCardRepository, userService);
        creditCard = new CreditCard(2, "1111222233330000", "MasterCard", "08.08.2027", 101, 1);
    }
}
