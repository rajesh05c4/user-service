package org.example.userservice.service;

import org.example.userservice.exception.DuplicateAccountTypeException;
import org.example.userservice.model.Account;
import org.example.userservice.repository.AccountRepository;
import org.example.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRepository userRepository;

    public Account createAccount(Account account) {
        if (!userRepository.existsById(account.getUserId())) {
            throw new IllegalArgumentException("User with ID " + account.getUserId() + " does not exist.");
        }

        if (accountRepository.existsByUserIdAndAccountType(account.getUserId(), account.getAccountType())) {
            throw new DuplicateAccountTypeException(
                    "User " + account.getUserId() + " already has a " + account.getAccountType() + " account."
            );
        }
        return accountRepository.save(account);
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }
}
