package com.dotin.interview.transaction.processing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.dotin.interview.transaction.processing.model.Account;
import com.dotin.interview.transaction.processing.model.Card;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
	Account findByAccountNumber(@Param("accountNumber") String accountNumber);
}
