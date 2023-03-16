package com.leasing.domain;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;
@Data
@Entity
@Table(name = "credit_card")
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="credit_card_seq")
    @SequenceGenerator(name = "credit_card_seq", sequenceName = "credit_card_id_seq", allocationSize = 1)
    private int id;
    @Column(name = "card_number")
    private String cardNumber;
    @Column(name = "card_type")
    private String cardType;
    @Column(name = "expiration_date")
    private LocalDate expirationDate;
    @Size(min = 3, max = 3)
    @Column(name = "cvc_code")
    private int cvcCode;
//    @Column(name = "user_id")
//    private int userId;
}
