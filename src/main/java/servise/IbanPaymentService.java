package servise;


import com.example.app_bank1.other_paymens.categories.IbanPayment;
import org.springframework.stereotype.Service;
import repository.IbanPaymentRepository;

import java.util.List;

@Service
    public class IbanPaymentService {

        private final IbanPaymentRepository ibanPaymentRepository;

        public IbanPaymentService(IbanPaymentRepository ibanPaymentRepository) {
            this.ibanPaymentRepository = ibanPaymentRepository;
        }

        public List<IbanPayment> getAllPayments() {
            return ibanPaymentRepository.findAll();
        }

        public void makePayment(IbanPayment ibanPayment) {
            // Логика выполнения оплаты по IBAN
            // Например, вызов API платежной системы для осуществлен


        }}
