package com.leasing.domain;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Date;
@Data
@Entity
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
    private Date term;
    @Column(name = "payment")
    private double payment;
    @Column(name = "debt")
    private double debt;
    @Column(name = "credit")
    private double credit;
    @Column(name = "user_id")
    private int user_id;
}
