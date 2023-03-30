package com.leasing.domain;
import lombok.Data;
import javax.persistence.*;
@Data
@Entity
@Table(name = "agreement_info")
public class AgreementInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "info_seq")
    @SequenceGenerator(name = "info_seq", sequenceName = "agreement_info_id_seq", allocationSize = 1)
    private int id;
    @Column(name = "make")
    private String make;
    @Column(name = "model")
    private String model;
    @Column(name = "year")
    private int year;
    @Column(name = "agreement_id")
    private String agreementId;
}
