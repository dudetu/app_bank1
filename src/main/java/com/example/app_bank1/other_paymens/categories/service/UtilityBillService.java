package com.example.app_bank1.other_paymens.categories.service;



import com.example.app_bank1.other_paymens.categories.entity.UtilityBill;
import org.springframework.stereotype.Service;
import com.example.app_bank1.other_paymens.categories.repository.UtilityBillRepository;

import java.util.List;

/**
 *
 *
 */
@Service
public class UtilityBillService {

    private final UtilityBillRepository utilityBillRepository;

    public UtilityBillService(UtilityBillRepository utilityBillRepository) {
        this.utilityBillRepository = utilityBillRepository;
    }

    /**
     * Соберите все счета за коммунальные услуги.
     * Get all utility bills.
     *
     * Cписок счетов за коммунальные услуги
     * @return the list of utility bills
     */
    public List<UtilityBill> getAllBills() {
        return utilityBillRepository.findAll();
    }
}


