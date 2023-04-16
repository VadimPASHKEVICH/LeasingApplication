package com.leasing.repository;

import com.leasing.domain.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard,Integer> {
    @Query(nativeQuery = true, value = "SELECT *FROM credit_card WHERE user_id = userId")
    ArrayList<CreditCard> getCreditCardByUserId(int userId);

}
