package com.example.app_bank1.other_paymens.categories.repository;
import com.example.app_bank1.other_paymens.categories.entity.ClientAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

/**
 * Репозиторий для работы с клиентскими аккаунтами.
 */
@Repository
public interface ClientAccountRepository extends JpaRepository<ClientAccount, Long> {

    /**
     * Найти клиентский аккаунт по имени владельца.
     *
     * @param ownerName Имя владельца клиентского аккаунта.
     * @return Список клиентских аккаунтов с заданным именем владельца.
     */
    @Query("SELECT c FROM ClientAccount c WHERE c.ownerName = :ownerName")
    List<ClientAccount> findByOwnerName(@Param("ownerName") String ownerName);

    /**
     * Найти клиентский аккаунт по адресу электронной почты.
     *
     * @param email Адрес электронной почты клиентского аккаунта.
     * @return Клиентский аккаунт с заданным адресом электронной почты, если существует.
     */
    @Query("SELECT c FROM ClientAccount c WHERE c.email = :email")
    Optional<ClientAccount> findByEmail(@Param("email") String email);

    /**
     * Найти клиентский аккаунт, который имеет банковский счет с определенным номером.
     *
     * @param accountNumber Номер банковского счета.
     * @return Список клиентских аккаунтов, связанных с банковским счетом с заданным номером.
     */
    @Query("SELECT c FROM ClientAccount c JOIN c.bankAccounts b WHERE b.accountNumber = :accountNumber")
    List<ClientAccount> findByBankAccountNumber(@Param("accountNumber") String accountNumber);

    /**
     * Найти клиентский аккаунт, который имеет кредитную карту с определенным номером.
     *
     * @param creditCardNumber Номер кредитной карты.
     * @return Список клиентских аккаунтов, связанных с кредитной картой с заданным номером.
     */
    @Query("SELECT c FROM ClientAccount c JOIN c.creditCards cc WHERE cc.creditCardNumber = :creditCardNumber")
    List<ClientAccount> findByCreditCardNumber(@Param("creditCardNumber") String creditCardNumber);
}

