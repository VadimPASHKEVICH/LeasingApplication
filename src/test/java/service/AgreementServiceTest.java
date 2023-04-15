package service;

import com.leasing.domain.Agreement;
import com.leasing.repository.AgreementRepository;
import com.leasing.service.AgreementService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.List;
import java.util.Optional;
import static org.mockito.Mockito.*;

public class AgreementServiceTest {
    @Mock
    private AgreementRepository agreementRepository;

    private AgreementService agreementService;

    private Agreement agreement;

    private List<Agreement> agreements;

    @BeforeEach
    void setAgreement() {
        MockitoAnnotations.openMocks(this);
        agreementService = new AgreementService(agreementRepository, agreementService);
        agreement = new Agreement(10, 123456, "29.09.2024", 2221, 0, 100);
    }

    @Test
    void getAllAgreement() {
        when(agreementRepository.findAll()).thenReturn(agreements);
        Optional<List<Agreement>> optionalBooks = Optional.ofNullable(agreementService.getAllAgreements());

        Assertions.assertTrue(optionalBooks.isPresent());
        verify(agreementRepository, times(1)).findAll();
    }

    @Test
    void createAgreement() {
        agreementService = new AgreementService(agreementRepository, agreementService);
        agreement = new Agreement(66, 000006, "01.01.2024", 10, 0.1, 100);
    }

    @Test
    void deleteAgreement() {
        agreementService = new AgreementService(agreementRepository, agreementService);
        agreement = new Agreement(66, 000006, "01.01.2024", 10, 0.1, 100);
    }
}
