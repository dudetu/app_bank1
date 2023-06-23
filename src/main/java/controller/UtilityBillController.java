package controller;


import com.example.app_bank1.other_paymens.categories.UtilityBill;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import servise.UtilityBillService;

import java.util.List;

@RestController
    @RequestMapping("/utility-bills")
    public class UtilityBillController {

        private final UtilityBillService utilityBillService;

        public UtilityBillController(UtilityBillService utilityBillService) {
            this.utilityBillService = utilityBillService;
        }

        @GetMapping
        public List<UtilityBill> getAllBills() {
            return utilityBillService.getAllBills();
        }

        @PostMapping
        public ResponseEntity<String> createBill(@RequestBody UtilityBill utilityBill) {
            utilityBillService.createBill(utilityBill);
            return ResponseEntity.ok("Utility bill created successfully");
        }

        // Другие методы для обработки коммунальных платежей
    }


