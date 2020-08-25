package com.dotin.interview.transaction.processing.repository;

import java.util.Date;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dotin.interview.transaction.processing.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	@Query(value = "SELECT transaction FROM TRANSACTION transaction WHERE transaction.cardNumber=cardNumber and "
			+ "transaction.transactionDate >= startDate and transaction.transactionDate < endDate ", nativeQuery = true)
	Set<Transaction> findAllByCardAndDate(String cardNumber, Date startDate, Date endDate);

	@Query(value = "SELECT transaction FROM TRANSACTION transaction WHERE transaction.cardNumber=cardNumber ORDER BY transaction.transactionDate DESC LIMIT 10", nativeQuery = true)
	Set<Transaction> getLastTenTransactions(String cardNumber);

}
