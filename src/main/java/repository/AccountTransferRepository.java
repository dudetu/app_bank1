package repository;

import com.example.app_bank1.other_paymens.categories.AccountTransfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountTransferRepository extends JpaRepository<AccountTransfer, Long> {

    // Методы для выполнения операций с переводами на счет
}

