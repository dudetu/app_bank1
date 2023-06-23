package controller;

import com.example.app_bank1.other_paymens.categories.FinePayment;
import servise.FinePaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping("/fine-payments")
    public class FinePaymentController {

        private final FinePaymentService finePaymentService;

        public FinePaymentController(FinePaymentService finePaymentService) {
            this.finePaymentService = finePaymentService;
        }

        @GetMapping
        public List<FinePayment> getAllPayments() {
            return finePaymentService.getAllPayments();
        }

        @PostMapping
        public ResponseEntity<String> makePayment(@RequestBody FinePayment finePayment) {
            finePaymentService.makePayment(finePayment);
            return ResponseEntity.ok("Fine payment successful");
        }

        // Другие методы для обработки оплаты штрафов
    }



