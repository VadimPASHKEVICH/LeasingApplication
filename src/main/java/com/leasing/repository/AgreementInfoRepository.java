package com.leasing.repository;

import com.leasing.domain.AgreementInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgreementInfoRepository extends JpaRepository<AgreementInfo, Integer> {
}
