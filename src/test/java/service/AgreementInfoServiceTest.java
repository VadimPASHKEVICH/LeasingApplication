package service;

import com.leasing.domain.AgreementInfo;
import com.leasing.repository.AgreementInfoRepository;
import com.leasing.service.AgreementInfoService;
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

public class AgreementInfoServiceTest {

    @Mock
    private AgreementInfoRepository agreementInfoRepository;

    private AgreementInfoService agreementInfoService;

    private AgreementInfo agreementInfo;

    private List<AgreementInfo> agreementInfoList;

    @BeforeEach
    void setAgreementInfo() {
        MockitoAnnotations.openMocks(this);
        agreementInfoService = new AgreementInfoService(agreementInfoRepository, agreementInfoService);
        agreementInfo = new AgreementInfo(33, "Opel", "Insignia", 2010, 4);
        agreementInfoList = new ArrayList<>();
        agreementInfoList.add(agreementInfo);
        agreementInfoRepository.save(agreementInfo);
    }

    @Test
    void getAgInfoById() {
        when(agreementInfoRepository.findById(agreementInfo.getId())).thenReturn(Optional.ofNullable(agreementInfo));
        Optional<AgreementInfo> optionalArticle = Optional.ofNullable(agreementInfoService.getAgInfoById(agreementInfo.getId()));

        assertTrue(optionalArticle.isPresent());
        verify(agreementInfoRepository, times(1)).findById(agreementInfo.getId());
    }
}
