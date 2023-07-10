package com.example.app_bank1.other_paymens.categories.repository;


import com.example.app_bank1.other_paymens.categories.entity.payments.FinePayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**

 Repository interface for managing FinePayment entities.

 Provides methods for saving and retrieving fine payments.
 */
@Repository
public interface FinePaymentRepository extends JpaRepository<FinePayment, Long> {

    /**

     Saves a fine payment.
     @param finePayment The fine payment to be saved.
     @return The saved fine payment.
     */
    FinePayment save(FinePayment finePayment);
}








