package com.dotin.interview.transaction.processing.repository;

import java.util.Date;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dotin.interview.transaction.processing.model.Transaction;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.annotation.security.PermitAll;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	@Query(value = "SELECT transaction FROM TRANSACTION transaction " +
			"WHERE transaction.cardNumber = :cardNumber AND " +
			"transaction.transactionDate >= :startDate " +
			"and transaction.transactionDate < :endDate ", nativeQuery = true)
	Set<Transaction> findAllByCardAndDate(@Param("cardNumber") String cardNumber,
										  @Param("startDate") Date startDate,
										  @Param("endDate") Date endDate);

	@Query(value = "SELECT transaction FROM TRANSACTION transaction " +
			"WHERE transaction.cardNumber = :cardNumber " +
			"ORDER BY transaction.transactionDate DESC " +
			"LIMIT 10", nativeQuery = true)
	Set<Transaction> getLastTenTransactions(@Param("cardNumber") String cardNumber);

	@Query(value = "SELECT transaction FROM TRANSACTION transaction " +
			"WHERE transaction.transactionDate = :transactionDate " +
			"AND transaction.followUpNumber = :followUpNumber " +
			"AND transaction.cardNumber = :cardNumber " +
			"AND transaction.terminalType = :terminalType" , nativeQuery = true)
	Transaction findDuplicateTransaction(@Param("followUpNumber") String followUpNumber,
									 @Param("cardNumber") String cardNumber,
									 @Param("transactionDate") Date transactionDate,
									 @Param("terminalType") String terminalType);

}
