package com.leasing.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "agreement_info")
public class AgreementInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "info_seq")
    @SequenceGenerator(name = "info_seq", sequenceName = "agreement_info_id_seq", allocationSize = 1)
    private int id;
    @NotBlank
    @Column(name = "make")
    private String make;
    @NotBlank
    @Column(name = "model")
    private String model;
    @NotBlank
    @Column(name = "year")
    private int year;
    @NotBlank
    @Column(name = "agreement_id")
    private int agreementId;

}
