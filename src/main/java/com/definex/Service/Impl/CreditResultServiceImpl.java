package com.definex.Service.Impl;

import com.definex.dto.CustomerDTO;
import com.definex.Repository.CustomerRepository;
import com.definex.Service.CreditResultService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Data
@RequiredArgsConstructor
public class CreditResultServiceImpl implements CreditResultService {
    private final ModelMapper modelMapper;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public boolean calculateCreditResult(CustomerDTO customer) {
        int creditScore = customer.getCreditScore();
        double creditLimitMultiplier = 4.0; // Varsayılan kredi limit çarpanı

        if (creditScore < 500) {
            customer.setCreditResult(false);
            customer.setCreditLimit(0);
            return false;
        } else if (creditScore >= 500 && creditScore <= 1000 && customer.getMonthlyIncome() < 5000) {
            double limit = 10000.0;
            if (customer.getCollateral() != 0) {
                limit += customer.getCollateral() * 0.1;
            }
            customer.setCreditLimit(limit);
            return true;
        } else if (creditScore >= 500 && creditScore <= 1000 && customer.getMonthlyIncome() >= 5000 && customer.getMonthlyIncome() <= 10000) {
            double limit = 20000.0;
            if (customer.getCollateral() != 0) {
                limit += customer.getCollateral() * 0.2;
                customer.setCreditLimit(limit);
            }
            return true;
        } else if (creditScore >= 500 && creditScore <= 1000 && customer.getMonthlyIncome() > 10000) {
            double limit = customer.getMonthlyIncome() * creditLimitMultiplier / 2;
            if (customer.getCollateral() != 0) {
                limit += customer.getCollateral() * 0.25;
                customer.setCreditLimit(limit);
            }
            return true;
        } else if (creditScore >= 1000) {
            double limit = customer.getMonthlyIncome() * creditLimitMultiplier;
            if (customer.getCollateral() != 0) {
                limit += customer.getCollateral() * 0.5;
                customer.setCreditLimit(limit);
            }
        } else {
            return false;
        }
        return false;
    }
}


    