package servise;

import com.example.app_bank1.other_paymens.categories.CreditCardTopUp;
import org.springframework.stereotype.Service;
import repository.CreditCardTopUpRepository;

import java.util.List;

@Service
public class CreditCardTopUpService {

    private final CreditCardTopUpRepository creditCardTopUpRepository;

    public CreditCardTopUpService(CreditCardTopUpRepository creditCardTopUpRepository) {
        this.creditCardTopUpRepository = creditCardTopUpRepository;
    }

    public List<CreditCardTopUp> getAllTopUps() {
        return creditCardTopUpRepository.findAll();
    }

    public void topUpCreditCard(CreditCardTopUp creditCardTopUp) {
        // Логика выполнения пополнения кредитной карточки
        // Например, вызов API платежной системы для осуществления пополнения
        // и сохранение информации о пополнении в базу данных
        creditCardTopUpRepository.save(creditCardTopUp);
    }

    // Другие методы для работы с пополнением кредитной карточки
}
