package com.definex.Service;

import com.definex.dto.CustomerDTO;

import java.util.List;

public interface CustomerService  extends HelperService<CustomerDTO>{
    List<CustomerDTO> getCustomerList();

}
