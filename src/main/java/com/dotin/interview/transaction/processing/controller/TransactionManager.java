package com.dotin.interview.transaction.processing.controller;

import java.util.Date;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dotin.interview.transaction.processing.enums.ResponseStateEnum;
import com.dotin.interview.transaction.processing.model.Account;
import com.dotin.interview.transaction.processing.model.Card;
import com.dotin.interview.transaction.processing.model.Transaction;
import com.dotin.interview.transaction.processing.repository.CardRepository;
import com.dotin.interview.transaction.processing.repository.TransactionRepository;
import com.dotin.interview.transaction.processing.request.CartToCartTransactionRequest;
import com.dotin.interview.transaction.processing.request.DailyCashFlowTransactionRequest;
import com.dotin.interview.transaction.processing.request.Request;
import com.dotin.interview.transaction.processing.response.CashFlowTranactionsResponse;
import com.dotin.interview.transaction.processing.response.CurrentExistingAmount;
import com.dotin.interview.transaction.processing.response.Response;

@RestController
@RequestMapping("/mainTransactions")
public class TransactionManager {

	private final CardRepository cardRepository;
	private final TransactionRepository transactonRepository;

	public TransactionManager(CardRepository cardRepository, TransactionRepository transactonRepository) {
		super();
		this.cardRepository = cardRepository;
		this.transactonRepository = transactonRepository;
	}

	@GetMapping("/existingAmount")
	public Response getDailyCashFlow(Request request) {
		Card storedCard = cardRepository.findByCardNumber(request.getCardNumber());
		Account mainAccount = null;
		for (Account account : storedCard.getAccounts()) {
			if (account.isPrimary()) {
				mainAccount = account; // it's a bad idea to do this but i ran out of ideas at this time
			} // just for now all object must be validated before creating response message
		}
		CurrentExistingAmount response = new CurrentExistingAmount(storedCard.getCardNumber(),
				request.getFollowUpCode(), ResponseStateEnum.SUCCESSFUL, mainAccount.getAmount());
		Transaction transaction = new Transaction(new Date(), request.getTerminalType(), request.getFollowUpCode(),
				storedCard.getCardNumber(), -500, ResponseStateEnum.SUCCESSFUL.getCode());
		return response;

	}

	@GetMapping("/tenLastTransactions")
	public Response getTenLastTransactions(Request request) {
		Card storedCard = cardRepository.findByCardNumber(request.getCardNumber());
		Set<Transaction> transactions = null;
		transactions = transactonRepository.getLastTenTransactions(storedCard.getCardNumber());
		CashFlowTranactionsResponse cashFlowTransactionResponse = new CashFlowTranactionsResponse(
				storedCard.getCardNumber(), request.getFollowUpCode(), ResponseStateEnum.SUCCESSFUL, transactions);
		return cashFlowTransactionResponse;

	}

	@GetMapping("/getDailyTransactions")
	public Response getDailyTransactions(DailyCashFlowTransactionRequest request) {
		Card storedCard = cardRepository.findByCardNumber(request.getCardNumber());
		Set<Transaction> transactions = transactonRepository.findAllByCardAndDate(storedCard.getCardNumber(),
				request.getStartDate(), request.getEndDate());
		CashFlowTranactionsResponse response = new CashFlowTranactionsResponse(storedCard.getCardNumber(), request.getFollowUpCode(), ResponseStateEnum.SUCCESSFUL, transactions)
		return response;
	}

	@PostMapping("cartTocartTransaction")
	@Transactional
	public Response cartToCartTransaction(CartToCartTransactionRequest request) {

		return null;

	}

}
