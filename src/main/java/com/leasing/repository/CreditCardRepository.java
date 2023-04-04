package com.leasing.repository;
import com.leasing.domain.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Integer> {

}
