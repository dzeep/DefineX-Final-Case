package com.definex.Service;

import com.definex.dto.PaymentDTO;

import java.util.List;

public interface PaymentService extends HelperService<PaymentDTO>{
    List<PaymentDTO> getPaymentList();
}
