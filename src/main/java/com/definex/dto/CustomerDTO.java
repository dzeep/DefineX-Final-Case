package com.definex.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class CustomerDTO implements Serializable {

    private Long id;
    private String identityNumber;
    private String fullName;
    private double monthlyIncome;
    private String phoneNumber;
    private LocalDate birthDate;
    private double collateral;
    private int creditScore;
    private boolean creditResult;
    private double creditLimit;





}