package service;

import com.leasing.domain.CreditCard;
import com.leasing.repository.CreditCardRepository;
import com.leasing.service.CreditCardService;
import com.leasing.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class CreditCardServiceTest {
    @Mock
    private CreditCardRepository creditCardRepository;

    private CreditCardService creditCardService;

    private CreditCard creditCard;

    private List<CreditCard> creditCards;

    @BeforeEach
    void setCreditCard() {
        MockitoAnnotations.openMocks(this);
        creditCardService = new CreditCardService(creditCardRepository);
        creditCard = new CreditCard(1, "1111 2222 3333 4444", "MasterCard", "09/26", 101);
        creditCards = new ArrayList<>();
        creditCards.add(creditCard);
        creditCardRepository.save(creditCard);
    }
}
