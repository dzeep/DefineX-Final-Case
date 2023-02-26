package com.definex.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class BillDTO implements Serializable {

    private static final long serialVersionUID = 4272216365310554502L;

    private Long id;
    private String billNumber;
    private Double amounthOfBill;
    private LocalDate billProcessDate;
}