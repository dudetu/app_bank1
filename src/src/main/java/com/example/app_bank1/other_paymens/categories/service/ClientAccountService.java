package com.example.app_bank1.other_paymens.categories.service;

import com.example.app_bank1.other_paymens.categories.entity.ClientAccount;
import com.example.app_bank1.other_paymens.categories.repository.ClientAccountRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Service class that provides methods to manage client accounts.
 */
@Service
public class ClientAccountService {

    private final ClientAccountRepository clientAccountRepository;

    /**
     * Constructs a new instance of ClientAccountService with the provided ClientAccountRepository.
     *
     * @param clientAccountRepository The repository used to access client account data.
     */
    @Autowired
    public ClientAccountService(ClientAccountRepository clientAccountRepository) {
        this.clientAccountRepository = clientAccountRepository;
    }

    /**
     * Retrieves a list of all client accounts.
     *
     * @return A list of client accounts.
     */
    public List<ClientAccount> getAllClientAccounts() {
        return clientAccountRepository.findAll();
    }

    /**
     * Retrieves a client account by its ID.
     *
     * @param id The ID of the client account to retrieve.
     * @return The client account with the specified ID.
     * @throws EntityNotFoundException If the client account with the given ID does not exist.
     */
    public ClientAccount getClientAccountById(Long id) {
        return clientAccountRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Client account with id " + id + " not found"));
    }

    /**
     * Creates a new client account.
     *
     * @param clientAccount The client account object to create.
     * @return The newly created client account.
     */
    public ClientAccount createClientAccount(ClientAccount clientAccount) {
        return clientAccountRepository.save(clientAccount);
    }

    /**
     * Updates an existing client account.
     *
     * @param clientAccount The client account object to update.
     * @return The updated client account.
     */
    public ClientAccount updateClientAccount(ClientAccount clientAccount) {
        return clientAccountRepository.save(clientAccount);
    }

    /**
     * Deletes a client account by its ID.
     *
     * @param id The ID of the client account to delete.
     */
    public void deleteClientAccountById(Long id) {
        clientAccountRepository.deleteById(id);
    }
}
