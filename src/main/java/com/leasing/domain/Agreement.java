package com.leasing.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "agreements")
public class Agreement {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "agreement_seq")
    @SequenceGenerator(name = "agreement_seq", sequenceName = "agreement_id_seq", allocationSize = 1)
    private int id;
    @NotBlank
    @Column(name = "agreement")
    private int agreement;
    @Column(name = "term")
    private String term;
    @Column(name = "payment")
    private double payment;
    @Column(name = "debt")
    private double debt;
    @Column(name = "credit")
    private double credit;
    @Column(name = "user_id")
    private int userId;
}
