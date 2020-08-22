package com.dotin.interview.transaction.processing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.dotin.interview.transaction.processing.model.Card;

public interface CardRepository extends JpaRepository<Card, Long> {
	Card findByCardNumber(@Param("cardNumber") String cardNumber );
}
