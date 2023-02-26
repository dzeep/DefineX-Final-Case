package com.definex.Service.Impl;



import com.definex.Model.Customer;
import com.definex.Repository.CustomerRepository;
import com.definex.Service.CreditService;
import com.definex.Service.CustomerService;
import com.definex.dto.CreditDTO;
import com.definex.dto.CustomerDTO;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Data
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;
    @Autowired
    private CreditService billService;
    @Override
    public List<CustomerDTO> getCustomerList(){
        List<Customer> customerList = (List<Customer>) customerRepository.findAll();
        return customerList.stream().map(branch -> modelMapper.map(branch, CustomerDTO.class)).collect(Collectors.toList());
    }

    @Override
    public CustomerDTO Create(CustomerDTO model) throws ParseException {
        Customer customer = modelMapper.map(model,Customer.class);
            CustomerDTO customerDTO = modelMapper.map(customerRepository.save(customer),CustomerDTO.class);
            CreditDTO creditDTO = new CreditDTO();
            creditDTO.setId(customer.getId());
            creditDTO.setCreditResult(customer.getCreditResult());
            creditDTO.setLimit(customer.getCreditLimit());
            creditDTO.setIdentityNumber(customer.getIdentityNumber());
            billService.Create(creditDTO);
            return customerDTO;

    }


    @Override
    public String Update(Long id, CustomerDTO model) {
        Customer customer = modelMapper.map(model,Customer.class);
        Optional<Customer> customer1 = customerRepository.findById(id);
        if(customer1.isPresent()){
        if(id.equals(model.getId())) {
        customerRepository.save(customer);
        return "ID:" + customer.getId() + " Updated!";}}
        throw new IllegalArgumentException(model + " Update Option Fail!");

    }

    @Override
    public String Delete(Long id) {
        Optional<Customer> customer1 = customerRepository.findById(id);
        if(customer1.isPresent()){
            customerRepository.deleteById(id);
            return id.toString();}
        else
            throw new IllegalArgumentException(" Delete Option Fail!");
    }

}


    