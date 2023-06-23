package servise;


import com.example.app_bank1.other_paymens.categories.FinePayment;
import org.springframework.stereotype.Service;
import repository.FinePaymentRepository;

import java.util.List;

@Service
    public class FinePaymentService {

        private final FinePaymentRepository finePaymentRepository;

        public FinePaymentService(FinePaymentRepository finePaymentRepository) {
            this.finePaymentRepository = finePaymentRepository;
        }

        public List<FinePayment> getAllPayments() {
            return finePaymentRepository.findAll();
        }

        public void makePayment(FinePayment finePayment) {
            // Логика выполнения оплаты штрафа
            // Например, вызов API платежной системы для осуществления платежа
            // и сохранение информации о платеже в базу данных
            finePaymentRepository.save(finePayment);
        }

        // Другие методы для работы с оплатами штрафов
    }



