package repository;

import com.example.app_bank1.other_paymens.categories.BankAccountPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountPaymentRepository extends JpaRepository<BankAccountPayment, Long> {

    // Методы для выполнения операций с пополнением банковского счета
}

