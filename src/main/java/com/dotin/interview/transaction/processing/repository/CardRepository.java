package com.dotin.interview.transaction.processing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dotin.interview.transaction.processing.model.Card;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
	Card findByCardNumber(@Param("cardNumber") String cardNumber );

	@Query("SELECT a.amount FROM Card c JOIN Account a WHERE c.cardNumber = :cardNumber AND c.mainAccount = a.accountNumber")
	Long findAmountByCardNumber(@Param("cardNumber") String cardNumber);


}
