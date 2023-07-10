package com.example.app_bank1.repository;



import com.example.app_bank1.other_paymens.categories.entity.payments.CreditCardPayment;
import com.example.app_bank1.other_paymens.categories.repository.CreditCardPaymentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@TestPropertySource(locations = "classpath:test.properties")
class CreditCardPaymentRepositoryTest {

    @Autowired
    private CreditCardPaymentRepository creditCardPaymentRepository;

    @Test
    void findByCreditCardNumber_ReturnsMatchingPayments() {
        // Упорядочить
        // Arrange
        CreditCardPayment payment1 = new CreditCardPayment();
        payment1.setCreditCardNumber("1234567890123456");
        creditCardPaymentRepository.save(payment1);

        CreditCardPayment payment2 = new CreditCardPayment();
        payment2.setCreditCardNumber("0987654321098765");
        creditCardPaymentRepository.save(payment2);
        // Действие
        // Act
        List<CreditCardPayment> payments = creditCardPaymentRepository.findByCreditCardNumber("1234567890123456");
        // Проверить
        // Assert
        assertEquals(1, payments.size());
        assertEquals(payment1, payments.get(0));
    }
}
