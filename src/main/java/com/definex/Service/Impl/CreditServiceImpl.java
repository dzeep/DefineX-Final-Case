package com.definex.Service.Impl;



import com.definex.Model.Credit;
import com.definex.Repository.CreditRepositrory;
import com.definex.Service.CreditService;
import com.definex.dto.CreditDTO;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Data
@RequiredArgsConstructor
public class CreditServiceImpl implements CreditService {

    private final CreditRepositrory billRepositrory;
    private final ModelMapper modelMapper;

    @Override
    public List<CreditDTO> getBillList(){
        List<Credit>  billList= (List<Credit>) billRepositrory.findAll();
        return billList.stream().map(bill -> modelMapper.map(bill, CreditDTO.class)).collect(Collectors.toList());
    }

    @Override
    public CreditDTO Create(CreditDTO model) throws ParseException {
        Credit bill = modelMapper.map(model, Credit.class);
            return modelMapper.map(billRepositrory.save(bill), CreditDTO.class);
    }


    @Override
    public String Update(Long id, CreditDTO model) {
        Credit bill = modelMapper.map(model, Credit.class);
        Optional<Credit> bill1 = billRepositrory.findById(id);
        if(bill1.isPresent()){
            if(id.equals(model.getId())) {
                billRepositrory.save(bill);
                return "ID:" + bill.getId() + " Updated!";}}
        throw new IllegalArgumentException(model + " Update Option Fail!");
    }

    @Override
    public String Delete(Long id) {
        Optional<Credit> _bill = billRepositrory.findById(id);
        if (_bill.isPresent()) {
            billRepositrory.deleteById(id);
            return id.toString() + "Deleted";
        } else
            throw new IllegalArgumentException(" Delete Option Fail!");
    }
}

