package com.example.app_bank1.repository;

import com.example.app_bank1.other_paymens.categories.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByUserId(Long userId);
    List<Payment> findByAmountGreaterThan(BigDecimal amount);
    List<Payment> findByStatus(String status);
    // Add more custom query methods as needed
}
