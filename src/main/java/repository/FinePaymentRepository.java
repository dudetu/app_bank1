package repository;


import com.example.app_bank1.other_paymens.categories.FinePayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface FinePaymentRepository extends JpaRepository<FinePayment, Long> {

        // Методы для выполнения операций с оплатами штрафов
    }


