package com.definex.Controller;

import com.definex.Model.Credit;
import com.definex.Repository.CreditRepositrory;
import com.definex.Service.CreditService;
import com.definex.dto.CreditDTO;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

@Data
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("credit")
@Slf4j
@RequiredArgsConstructor
public class CreditController {

    public CreditController(CreditService billService) {
        this.billService = billService;
    }
    @Autowired
    private CreditService billService;
    @Autowired
    private CreditRepositrory creditRepositrory;

    @GetMapping(value = "list")
    public ResponseEntity<List<CreditDTO>> getBillList() {
        List<CreditDTO> billList = billService.getBillList();
        log.info("All Activities Returned - {}",billList);
        return ResponseEntity.ok(billList);
    }

    @GetMapping(value = "checkCredit/{identitynumber}")
    public Credit checkCredit(@PathVariable String identitynumber){
        Credit credit = creditRepositrory.findByIdentityNumber(identitynumber);

        return credit;
    }

    @PostMapping(value = "save")
    public ResponseEntity<CreditDTO> saveBill(@RequestBody CreditDTO billDTO) throws ParseException {
        CreditDTO bill1 = billService.Create(billDTO);
        return ResponseEntity.ok(bill1);
    }



    @PutMapping(value = "update/{id}")
    public ResponseEntity<String> updateBill(@PathVariable Long id, @RequestBody CreditDTO billDTO) {
        String status = billService.Update(id,billDTO);
        log.info("bill Updated Status - {}",status);
        return ResponseEntity.ok("Credit updated!");
    }

    @DeleteMapping(value = "remove/{id}")
    public ResponseEntity<String> deleteBill(@PathVariable() Long id) {
        String status = billService.Delete(id);
        log.info("Credit Deleted Status - {}",status);
        return ResponseEntity.ok(id + "th Credit deleted!");
    }
}

