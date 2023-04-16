package com.leasing.repository;

import com.leasing.domain.Agreement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Repository
public interface AgreementRepository extends JpaRepository<Agreement, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM agreements WHERE user_id = :id")
    ArrayList<Agreement> getAgreementDebtByUserId(int id);
    @Query(nativeQuery = true, value = "SELECT * FROM agreements WHERE user_id = :userId" )
    public Agreement getAgreementByUserId(int userId);
    @Transactional
    @Query(nativeQuery = true, value = "SELECT * FROM agreements WHERE agreement = :agreement")
    Agreement getAgreementByNumber(int agreement);
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "DELETE FROM agreement WHERE agreement = :agreement ")
    void deleteAgreementByNumber(int agreement);
}
