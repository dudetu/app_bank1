package com.example.app_bank1.other_paymens.categories.repository;

import com.example.app_bank1.other_paymens.categories.entity.payments.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
/**

 Repository interface for managing Payment entities.

 Provides methods for saving and retrieving payments.
 */
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    /**

     Finds payments by user ID.
     @param usersId The ID of the user.
     @return The list of payments associated with the specified user ID.
     */
    List<Payment> findByUsersId(Long usersId);
    /**

     Finds payments with an amount greater than the specified value.
     @param amount The minimum amount for the payments.
     @return The list of payments with an amount greater than the specified value.
     */
    List<Payment> findByAmountGreaterThan(BigDecimal amount);
    /**

     Finds payments by status.
     @param status The status of the payments.
     @return The list of payments with the specified status.
     */
    List<Payment> findByStatus(String status);
}








