package com.leasing.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "agreements")
public class Agreement {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ag_seq")
    @SequenceGenerator(name = "ag_seq", sequenceName = "agreement_id_seq", allocationSize = 1)
    private int id;
    @Column(table = "agreement")
    private int agreement;
    @Column(table = "term")
    private String term;
    @Column(table = "payment")
    private double payment;
    @Column(table = "debt")
    private double debt;
    @Column(table = "credit")
    private double credit;
}
