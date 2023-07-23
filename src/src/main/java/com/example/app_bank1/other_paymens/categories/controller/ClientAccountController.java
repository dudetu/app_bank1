package com.example.app_bank1.other_paymens.categories.controller;


import com.example.app_bank1.other_paymens.categories.entity.ClientAccount;
import com.example.app_bank1.other_paymens.categories.service.ClientAccountService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
;

/**
 * REST Controller class to handle client account related HTTP requests.
 */
@RestController
@RequestMapping("/client-accounts")
public class ClientAccountController {

    private final ClientAccountService clientAccountService;

    /**
     * Constructs a new instance of ClientAccountController with the provided ClientAccountService.
     *
     * @param clientAccountService The service used to manage client accounts.
     */
    @Autowired
    public ClientAccountController(ClientAccountService clientAccountService) {
        this.clientAccountService = clientAccountService;
    }

    /**
     * Retrieves a list of all client accounts.
     *
     * @return A ResponseEntity containing the list of client accounts and an HTTP status code 200 (OK).
     */
    @GetMapping("/get-all")
    public ResponseEntity<List<ClientAccount>> getAllClientAccounts() {
        List<ClientAccount> clientAccounts = clientAccountService.getAllClientAccounts();
        return ResponseEntity.ok(clientAccounts);
    }

    /**
     * Retrieves a client account by its ID.
     *
     * @param id The ID of the client account to retrieve.
     * @return A ResponseEntity containing the client account and an HTTP status code 200 (OK).
     * @throws EntityNotFoundException If the client account with the given ID does not exist.
     */
    @GetMapping("/{id}")
    public ResponseEntity<ClientAccount> getClientAccountById(@PathVariable Long id) {
        ClientAccount clientAccount = clientAccountService.getClientAccountById(id);
        return ResponseEntity.ok(clientAccount);
    }

    /**
     * Creates a new client account.
     *
     * @param clientAccount The client account object to create.
     * @return A ResponseEntity containing the newly created client account and an HTTP status code 201 (CREATED).
     */
    @PostMapping("/create")
    public ResponseEntity<ClientAccount> createClientAccount(@RequestBody ClientAccount clientAccount) {
        ClientAccount createdClientAccount = clientAccountService.createClientAccount(clientAccount);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdClientAccount);
    }

    /**
     * Updates an existing client account.
     *
     * @param clientAccount The client account object to update.
     * @return A ResponseEntity containing the updated client account and an HTTP status code 200 (OK).
     * @throws EntityNotFoundException If the client account with the given ID does not exist.
     */
    @PutMapping("/{id}")
    public ResponseEntity<ClientAccount> updateClientAccount(@RequestBody ClientAccount clientAccount) {
        ClientAccount updatedClientAccount = clientAccountService.updateClientAccount(clientAccount);
        return ResponseEntity.ok(updatedClientAccount);
    }

    /**
     * Deletes a client account by its ID.
     *
     * @param id The ID of the client account to delete.
     * @return A ResponseEntity with an HTTP status code 204 (NO CONTENT) in case of successful deletion.
     * @throws EntityNotFoundException If the client account with the given ID does not exist.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClientAccount(@PathVariable Long id) {
        clientAccountService.deleteClientAccountById(id);
        return ResponseEntity.noContent().build();
    }
}
