package com.leasing.domain;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@Entity
@Table(name = "credit_card")
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "credit_card_seq")
    @SequenceGenerator(name = "credit_card_seq", sequenceName = "credit_card_id_seq", allocationSize = 1)
    private int id;
    @NotBlank
    @Column(name = "card_number")
    private String cardNumber;
    @NotBlank
    @Column(name = "card_type")
    private String cardType;
    @NotBlank
    @Column(name = "expiration_date")
    private String expirationDate;
    @NotBlank
    @Pattern(regexp = "[0-9]{3}")
    @Column(name = "cvc_code")
    private int cvcCode;
    @NotBlank
    @Column(name = "user_id")
    private int userId;

    public CreditCard(int id, String cardNumber, String cardType, String expirationDate, int cvcCode) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.cardType = cardType;
        this.expirationDate = expirationDate;
        this.cvcCode = cvcCode;
    }
}
