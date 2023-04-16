package service;

import com.leasing.domain.Agreement;
import com.leasing.repository.AgreementRepository;
import com.leasing.service.AgreementService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class AgreementServiceTest {
    @Mock
    private AgreementRepository agreementRepository;

    private AgreementService agreementService;

    private Agreement agreement;

    private List<Agreement> ListAgreement;

    @BeforeEach
    void setAgreement() {
        MockitoAnnotations.openMocks(this);
        agreementService = new AgreementService(agreementRepository);
        agreement = new Agreement(25, 0000025, "30.11.2025", 101.34, 0, 1000, 25);
        ListAgreement = new ArrayList<>();
        ListAgreement.add(agreement);
        agreementRepository.save(agreement);
    }

    @Test
    void getAllAgreement() {
        when(agreementRepository.findAll()).thenReturn(ListAgreement);
        Optional<List<Agreement>> optionalBooks = Optional.ofNullable(agreementService.getAllAgreements());

        Assertions.assertTrue(optionalBooks.isPresent());
        verify(agreementRepository, times(1)).findAll();
    }
    @Test
    void deleteAgreementByNumber(){
        when(agreementRepository.getAgreementByNumber(agreement.getAgreement())).thenReturn(agreement);
        assertTrue(agreementService.deleteAgreementNumber(agreement.getAgreement()));
        verify(agreementRepository, times(1)).deleteById(agreement.getId());
    }
}
