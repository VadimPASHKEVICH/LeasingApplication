package com.leasing.service;

import com.leasing.domain.Agreement;
import com.leasing.repository.AgreementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AgreementService {
    private final AgreementRepository agreementRepository;

    @Autowired
    public AgreementService(AgreementRepository agreementRepository) {
        this.agreementRepository = agreementRepository;
    }

    public Agreement getAgreementById(int id) {return agreementRepository.findById(id).get();}

    public void createAgreement(Agreement agreement) {
        agreementRepository.save(agreement);
    }

    public void updateAgreement(Agreement agreement) {
        agreementRepository.saveAndFlush(agreement);
    }

    public ArrayList<Agreement> getAllAgreements() {
        return (ArrayList<Agreement>) agreementRepository.findAll();
    }

    public void deleteAgreement(Agreement agreement) {agreementRepository.delete(agreement);}
}
