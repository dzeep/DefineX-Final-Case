package com.definex.dto;

import com.definex.Model.Customer;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class CreditDTO implements Serializable {

    private static final long serialVersionUID = 4272216365310554502L;

    private Long id;
    private String identityNumber;
    private Double limit;
    private String creditResult;
}