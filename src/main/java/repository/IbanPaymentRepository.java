package repository;


import com.example.app_bank1.other_paymens.categories.IbanPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface IbanPaymentRepository extends JpaRepository<IbanPayment, Long> {

        // Методы для выполнения операций с оплатами по IBAN
    }




