package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.leasing.controller.AgreementController;
import com.leasing.domain.Agreement;
import com.leasing.service.AgreementService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AgreementControllerTest {
    @Autowired
    private MockMvc mockMvc;

    private AgreementController agreementController;
    @Mock
    private AgreementService agreementService;

    private Agreement agreement;

    private List<Agreement> agreementList;

    @BeforeEach
    void setAgreement() {
        agreement = new Agreement(88, 1010012, "31.12.2023", 100.21, 0, 100000);
        agreementList = new ArrayList<>();
        agreementList.add(agreement);
    }

    @Test
    @WithMockUser(username = "user", password = "user", roles = "ADMIN")
    void createAgreement() throws Exception {
        Agreement newAg = new Agreement(55, 999999, "01.05.2024", 99.99, 0, 5000);
        doNothing().when(agreementService).createAgreement(newAg);

        mockMvc.perform(post("/agreement/createAg")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(newAg)))
                .andExpect(status().isCreated());
    }

    @Test
    @WithMockUser(username = "user", password = "user", roles = "ADMIN")
    void updateAgreement() throws Exception {
        Agreement newUpAg = new Agreement(56, 888888, "02.06.2024", 134.90, 0, 2000);
        doNothing().when(agreementService).createAgreement(newUpAg);

        mockMvc.perform(post("/agreement/updateAg")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(newUpAg)))
                .andExpect(status().isCreated());
    }
}
