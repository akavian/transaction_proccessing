package com.dotin.interview.transaction.processing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dotin.interview.transaction.processing.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
