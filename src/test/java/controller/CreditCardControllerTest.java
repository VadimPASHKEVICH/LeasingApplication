package controller;

import com.leasing.controller.CreditCardController;
import com.leasing.domain.CreditCard;
import com.leasing.repository.CreditCardRepository;
import com.leasing.service.CreditCardService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CreditCardControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private CreditCardController creditCardController;

    @Mock
    private CreditCardService creditCardService;

    private CreditCard creditCard;

    private List<CreditCard> creditCards;

    private CreditCardRepository creditCardRepository;

    @BeforeEach
    void setCreditCard(){
        creditCard = new CreditCard(3, "0000111199992222", "MasterCard", "31.10.2026", 111, 1);
        creditCards = new ArrayList<>();
        creditCards.add(creditCard);
        creditCardRepository.save(creditCard);
    }

//    @Test
//    @WithMockUser(username = "user", password = "user", roles = "USER")
//    void deleteCard() throws Exception {
//        creditCard = new CreditCard(3, "0000111199992222", "MasterCard", "31.10.2026", 111, 1);
//        when(creditCardService.deleteCard(creditCard));
//        mockMvc.perform(delete("/card//deleteCard", creditCard))
//                .andExpect(status().isOk()));
//    }
}

