package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.leasing.domain.Agreement;
import com.leasing.repository.AgreementRepository;
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

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.apache.logging.log4j.ThreadContext.get;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AgreementControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Mock
    private AgreementService agreementService;

    private Agreement agreement;

    private List<Agreement> agreementList;

    @BeforeEach
    void setAgreement() {
        agreement = new Agreement(2, 0000006, "05.05.2024", 55.76, 0, 1500, 4);
        agreementList = new ArrayList<>();
        agreementList.add(agreement);
    }

    @Test
    @WithMockUser(username = "user", password = "user", roles = "ADMIN")
    void getAgreementById()throws Exception{
        when(agreementService.getAgreementById(anyInt())).thenReturn(agreement);
        this.mockMvc.perform(get("/agreement/getBy{/id}", agreement.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(agreement.getId())));
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
