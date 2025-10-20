package org.example.userservice.repository;

import org.example.userservice.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    boolean existsByUserIdAndAccountType(Long userId, Account.AccountType accountType);
}
