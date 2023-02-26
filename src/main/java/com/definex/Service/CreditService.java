package com.definex.Service;

import com.definex.dto.CreditDTO;

import java.util.List;

public interface CreditService extends HelperService<CreditDTO> {
    List<CreditDTO> getBillList();

}
