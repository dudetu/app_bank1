package servise;

import com.example.app_bank1.other_paymens.categories.AccountTransfer;
import org.springframework.stereotype.Service;
import repository.AccountTransferRepository;

import java.util.List;

@Service
public class AccountTransferService {

    private final AccountTransferRepository accountTransferRepository;

    public AccountTransferService(AccountTransferRepository accountTransferRepository) {
        this.accountTransferRepository = accountTransferRepository;
    }

    public List<AccountTransfer> getAllTransfers() {
        return accountTransferRepository.findAll();
    }

    public void makeTransfer(AccountTransfer accountTransfer) {
        // Логика выполнения перевода на счет
        // Например, вызов API платежной системы для осуществления перевода
        // и сохранение информации о переводе в базу данных
        accountTransferRepository.save(accountTransfer);
    }

    // Другие методы для работы с переводами на счет
}
