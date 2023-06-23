package servise;


import com.example.app_bank1.other_paymens.categories.CreditCardPayment;
import org.springframework.stereotype.Service;
import repository.CreditCardPaymentRepository;

import java.util.List;

@Service
    public class CreditCardPaymentService {

        private final CreditCardPaymentRepository creditCardPaymentRepository;

        public CreditCardPaymentService(CreditCardPaymentRepository creditCardPaymentRepository) {
            this.creditCardPaymentRepository = creditCardPaymentRepository;
        }

        public List<CreditCardPayment> getAllPayments() {
            return creditCardPaymentRepository.findAll();
        }

        public void makePayment(CreditCardPayment creditCardPayment) {
            // Логика выполнения пополнения счета кредитной карты
            // Например, вызов API платежной системы для осуществления платежа
            // и сохранение информации о платеже в базу данных
            creditCardPaymentRepository.save(creditCardPayment);
        }

        // Другие методы для работы с пополнением счета кредитной карты
    }




