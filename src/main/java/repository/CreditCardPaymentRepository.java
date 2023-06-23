package repository;


import com.example.app_bank1.other_paymens.categories.CreditCardPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface CreditCardPaymentRepository extends JpaRepository<CreditCardPayment, Long> {

        // Методы для выполнения операций с пополнением счета кредитной карты
    }



