package com.definex.Model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "customer", schema = "public")
public class Customer {

    private static final long serialVersionUID = 8036849806134231488L;


    @Id
    @SequenceGenerator(name="identifier", sequenceName="mytable_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="identifier")
    private Long id;


    @Column(name = "identity_number", nullable = false)
    private String identityNumber;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "monthly_income", nullable = false)
    private double monthlyIncome;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(name = "collateral")
    private double collateral;

    @Column(name = "credit_score", nullable = true)
    private int creditScore;

    @Column(name = "credit_result", nullable = true)
    private boolean creditResult;

    @Column(name = "credit_limit", nullable = true)
    private double creditLimit;


}




    