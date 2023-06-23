package repository;


import com.example.app_bank1.other_paymens.categories.UtilityBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
    public interface UtilityBillRepository extends JpaRepository<UtilityBill, Long> {
    List<UtilityBill> findAll();

    // Методы для выполнения операций с коммунальными платежами
    }


