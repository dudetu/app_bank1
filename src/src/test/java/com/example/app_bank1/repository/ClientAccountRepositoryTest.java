package com.example.app_bank1.repository;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.example.app_bank1.other_paymens.categories.entity.ClientAccount;
import com.example.app_bank1.other_paymens.categories.repository.ClientAccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ClientAccountRepositoryTest {

    @Mock
    private ClientAccountRepository clientAccountRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAll() {
        // Arrange
        ClientAccount clientAccount1 = new ClientAccount();
        clientAccount1.setId(1L);
        ClientAccount clientAccount2 = new ClientAccount();
        clientAccount2.setId(2L);
        List<ClientAccount> clientAccounts = Arrays.asList(clientAccount1, clientAccount2);

        when(clientAccountRepository.findAll()).thenReturn(clientAccounts);

        // Act
        List<ClientAccount> result = clientAccountRepository.findAll();

        // Assert
        assertEquals(clientAccounts.size(), result.size());
        assertTrue(result.contains(clientAccount1));
        assertTrue(result.contains(clientAccount2));
    }

    @Test
    public void testFindById() {
        // Arrange
        Long accountId = 1L;
        ClientAccount clientAccount = new ClientAccount();
        clientAccount.setId(accountId);

        when(clientAccountRepository.findById(accountId)).thenReturn(Optional.of(clientAccount));

        // Act
        Optional<ClientAccount> result = clientAccountRepository.findById(accountId);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(accountId, result.get().getId());
    }

    @Test
    public void testFindById_NotFound() {
        // Arrange
        Long accountId = 1L;

        when(clientAccountRepository.findById(accountId)).thenReturn(Optional.empty());

        // Act & Assert
        assertFalse(clientAccountRepository.findById(accountId).isPresent());
    }

}
