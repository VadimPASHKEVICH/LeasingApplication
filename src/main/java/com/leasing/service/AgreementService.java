package com.leasing.service;

import com.leasing.domain.Agreement;
import com.leasing.domain.User;
import com.leasing.repository.AgreementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AgreementService {

    AgreementRepository agreementRepository;
    @Autowired
    public AgreementService(AgreementRepository agreementRepository) {this.agreementRepository = agreementRepository;}

    public void createAgreement(Agreement agreement){agreementRepository.save(agreement);}

    public void updateAgreement(Agreement agreement){agreementRepository.saveAndFlush(agreement);}
    public ArrayList<Agreement> getAllAgreements() {return (ArrayList<Agreement>) agreementRepository.findAll();}

    public Agreement getAgreementById(int id){return agreementRepository.findById(id).get();}
    public void deleteUser (Agreement agreement){agreementRepository.delete(agreement);}
}
