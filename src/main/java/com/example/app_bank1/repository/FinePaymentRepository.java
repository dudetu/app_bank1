package com.example.app_bank1.repository;


import com.example.app_bank1.other_paymens.categories.FinePayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FinePaymentRepository extends JpaRepository<FinePayment, Long> {
    // Метод сохранения оплаты штрафа
    // Method for saving the fine payment
    FinePayment save(FinePayment finePayment);


}


