package controller;

import com.example.app_bank1.other_paymens.categories.CreditCardTopUp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import servise.CreditCardTopUpService;

import java.util.List;

@RestController
@RequestMapping("/credit-card-top-ups")
public class CreditCardTopUpController {

    private final CreditCardTopUpService creditCardTopUpService;

    public CreditCardTopUpController(CreditCardTopUpService creditCardTopUpService) {
        this.creditCardTopUpService = creditCardTopUpService;
    }

    @GetMapping
    public List<CreditCardTopUp> getAllTopUps() {
        return creditCardTopUpService.getAllTopUps();
    }

    @PostMapping
    public ResponseEntity<String> topUpCreditCard(@RequestBody CreditCardTopUp creditCardTopUp) {
        creditCardTopUpService.topUpCreditCard(creditCardTopUp);
        ResponseEntity<String> ok = ResponseEntity.ok("Credit card top-up successful");

        return ok;
    }
}