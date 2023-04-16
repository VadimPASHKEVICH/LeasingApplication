package com.leasing.service;

import com.leasing.domain.AgreementInfo;
import com.leasing.repository.AgreementInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class AgreementInfoService {

    AgreementInfoRepository agreementInfoRepository;

    @Autowired
    public AgreementInfoService(AgreementInfoRepository agreementInfoRepository) {
        this.agreementInfoRepository = agreementInfoRepository;}

    public void createAgInfo(AgreementInfo agreementInfo) {
        agreementInfoRepository.save(agreementInfo);
    }

    public void updateAgInfo(AgreementInfo agreementInfo) {
        agreementInfoRepository.saveAndFlush(agreementInfo);
    }

    public ArrayList<AgreementInfo> getAllAgInfo() {return (ArrayList<AgreementInfo>) agreementInfoRepository.findAll();}

    public AgreementInfo getAgInfoById(int id) {
        return agreementInfoRepository.findById(id).get();
    }

    public void deleteAgInfo(AgreementInfo agreementInfo) {
        agreementInfoRepository.delete(agreementInfo);
    }
}
