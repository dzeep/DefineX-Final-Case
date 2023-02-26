package com.definex.Service;

import com.definex.dto.BillDTO;

import java.util.List;

public interface BillService extends HelperService<BillDTO> {
    List<BillDTO> getBillList();

}
