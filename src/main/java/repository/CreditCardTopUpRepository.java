package repository;

import com.example.app_bank1.other_paymens.categories.CreditCardTopUp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditCardTopUpRepository extends JpaRepository<CreditCardTopUp, Long> {


    // Методы для выполнения операций с пополнением кредитной карточки
}

