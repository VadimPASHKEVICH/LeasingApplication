package com.leasing.repository;
import com.leasing.domain.Agreement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;

@Repository
public interface AgreementRepository extends JpaRepository<Agreement, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM agreements WHERE debt = :debt")
    ArrayList<Agreement>getAgreementsWhereDebt();
}
