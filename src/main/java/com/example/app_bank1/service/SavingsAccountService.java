package com.example.app_bank1.service;

import com.example.app_bank1.other_paymens.categories.accumulation.SavingsAccount;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import com.example.app_bank1.repository.SavingsAccountRepository;

@Service
public class SavingsAccountService {

    private final SavingsAccountRepository savingsAccountRepository;

    public SavingsAccountService(SavingsAccountRepository savingsAccountRepository) {
        this.savingsAccountRepository = savingsAccountRepository;
    }

    public SavingsAccount getSavingsAccountById(Long id) throws ChangeSetPersister.NotFoundException {
        return savingsAccountRepository.findById(id)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        // Метод возвращает объект сберегательного счета по его идентификатору.
        // Если счет не найден, выбрасывается исключение ChangeSetPersister.NotFoundException.

        // The method returns the savings account object by its identifier.
        // If the account is not found, ChangeSetPersister.NotFoundException is thrown.
    }

    public SavingsAccount createSavingsAccount(SavingsAccount savingsAccount) {
        // Логика создания сберегательного счета, если необходимо
        // The logic of creating a savings account, if necessary

        return savingsAccountRepository.save(savingsAccount);
        // Метод сохраняет новый сберегательный счет в репозитории и возвращает сохраненный счет.
        // The method saves a new savings account in the repository and returns the saved account.
    }

    public SavingsAccount updateSavingsAccount(Long id, SavingsAccount savingsAccount)
            throws ChangeSetPersister.NotFoundException {
        SavingsAccount existingAccount = savingsAccountRepository.findById(id)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());

        // Логика обновления полей счета, если необходимо
        // Logic to update the account fields, if necessary


        return savingsAccountRepository.save(existingAccount);
        // Метод сохраняет обновленный сберегательный счет в репозитории и возвращает обновленный счет.
        // The method saves the updated savings account in the repository and returns the updated account.
    }

    public void deleteSavingsAccount(Long id) throws ChangeSetPersister.NotFoundException {
        SavingsAccount existingAccount = savingsAccountRepository.findById(id)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());

        // Дополнительная логика перед удалением счета, если необходимо
        // Additional logic before deleting an account, if necessary

        savingsAccountRepository.delete(existingAccount);
        // Метод удаляет существующий сберегательный счет из репозитория.
        // The method removes an existing savings account from the repository.
    }

}
