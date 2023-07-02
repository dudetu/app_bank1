package com.example.app_bank1.service;

import com.example.app_bank1.other_paymens.categories.UtilityBill;
import org.springframework.stereotype.Service;
import com.example.app_bank1.repository.UtilityBillRepository;

import java.util.List;

@Service
public class UtilityBillService {

    private final UtilityBillRepository utilityBillRepository;

    public UtilityBillService(UtilityBillRepository utilityBillRepository) {
        this.utilityBillRepository = utilityBillRepository;
    }

    public List<UtilityBill> getAllBills() {
        return utilityBillRepository.findAll();
    }

    public void createBill(UtilityBill utilityBill) {
        utilityBillRepository.save(utilityBill);
    }


    public void setUtilityBills(List<UtilityBill> utilityBills) {
    }


}


