package com.definex.Controller;


import com.definex.Service.CreditResultService;
import com.definex.Service.CustomerService;
import com.definex.dto.CustomerDTO;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@Data
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("customer")
@Slf4j
@RequiredArgsConstructor
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private CreditResultService creditResultService;

    @GetMapping(value = "list")
    public ResponseEntity<List<CustomerDTO>> getCustomerList() {
        List<CustomerDTO> customers = customerService.getCustomerList();
        log.info("All Activities Returned - {}",customers);
        return ResponseEntity.ok(customers);
    }

    @PostMapping(value = "save")
    public ResponseEntity saveCustomer(@RequestBody CustomerDTO customerDTO) throws ParseException {
        customerDTO.setId(customerDTO.getId());
        int max = 1000; //max credit score
        int min = 0;   // min credit score
        int randomCreditScore = (int) ((Math.random() * (max - min)) + min);
        customerDTO.setCreditScore(randomCreditScore) ;
        creditResultService.calculateCreditResult(customerDTO);
        customerService.Create(customerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body( "Account created successfully!");
    }



    @PutMapping(value = "update/{id}")
    public ResponseEntity<String> updateCustomer(@PathVariable Long id, @RequestBody CustomerDTO customerDTO) {
        String status = customerService.Update(id,customerDTO);
        log.info("Customer Updated Status - {}",status);
        return ResponseEntity.ok("Customer updated!");
    }

    @DeleteMapping(value = "remove/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable() Long id) {
        String status = customerService.Delete(id);
        log.info("Customer Deleted Status - {}",status);
        return ResponseEntity.ok(id + "th Customer deleted!");
    }
}


    