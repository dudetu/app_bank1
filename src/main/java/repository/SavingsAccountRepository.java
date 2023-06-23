package repository;

import com.example.app_bank1.other_paymens.categories.accumulation.SavingsAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
 interface SavingsAccountRepository extends JpaRepository<SavingsAccount, Long> {
    // Дополнительные методы для работы с базой данных
}


