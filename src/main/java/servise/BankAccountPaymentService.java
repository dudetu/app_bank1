package servise;

import com.example.app_bank1.other_paymens.categories.BankAccountPayment;
import org.springframework.stereotype.Service;
import repository.BankAccountPaymentRepository;

import java.util.List;

@Service
public class BankAccountPaymentService {

    private final BankAccountPaymentRepository bankAccountPaymentRepository;

    public BankAccountPaymentService(BankAccountPaymentRepository bankAccountPaymentRepository) {
        this.bankAccountPaymentRepository = bankAccountPaymentRepository;
    }

    public List<BankAccountPayment> getAllPayments() {
        return bankAccountPaymentRepository.findAll();
    }

    public void makePayment(BankAccountPayment bankAccountPayment) {
        // Логика выполнения пополнения банковского счета
        // Например, вызов API платежной системы для осуществления платежа
        // и сохранение информации о платеже в базу данных
        bankAccountPaymentRepository.save(bankAccountPayment);
    }

    // Другие методы для работы с пополнением банковского счета
}
