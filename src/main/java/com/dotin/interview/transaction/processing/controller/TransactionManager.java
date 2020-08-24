package com.dotin.interview.transaction.processing.controller;

import java.util.Date;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dotin.interview.transaction.processing.enums.ResponseStateEnum;
import com.dotin.interview.transaction.processing.enums.TerminalTypeEnum;
import com.dotin.interview.transaction.processing.model.Account;
import com.dotin.interview.transaction.processing.model.Card;
import com.dotin.interview.transaction.processing.model.Transaction;
import com.dotin.interview.transaction.processing.repository.AccountRepository;
import com.dotin.interview.transaction.processing.repository.CardRepository;
import com.dotin.interview.transaction.processing.repository.TransactionRepository;
import com.dotin.interview.transaction.processing.request.CartToCartTransactionRequest;
import com.dotin.interview.transaction.processing.request.DailyCashFlowTransactionRequest;
import com.dotin.interview.transaction.processing.request.Request;
import com.dotin.interview.transaction.processing.response.CartToCartTransactionResponse;
import com.dotin.interview.transaction.processing.response.CashFlowTranactionsResponse;
import com.dotin.interview.transaction.processing.response.CurrentExistingAmount;
import com.dotin.interview.transaction.processing.response.Response;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
/*Obviously there should be validation but I couldn't finish it in time. This project will be updated soon*/
@RestController
@RequestMapping("/mainTransactions")
public class TransactionManager {

	private final CardRepository cardRepository;
	private final TransactionRepository transactonRepository;
	private final AccountRepository accountRepository;

	public TransactionManager(CardRepository cardRepository, TransactionRepository transactonRepository, AccountRepository accountRepository) {
		super();
		this.cardRepository = cardRepository;
		this.transactonRepository = transactonRepository;
		this.accountRepository = accountRepository;
	}

	@PostMapping("/existingAmount")
	@Transactional
	public Response getDailyCashFlow(@RequestBody Request request) {
		Card storedCard = cardRepository.findByCardNumber(request.getCardNumber());
		double amount = fee(request.getTerminalType());
		
		Transaction transaction = new Transaction(new Date(), request.getTerminalType(), request.getFollowUpCode(),
				storedCard.getCardNumber(), amount, ResponseStateEnum.SUCCESSFUL.getCode());
		Account account = accountRepository.findByAccountNumber(storedCard.getMainAccount());
		account.setAmount(account.getAmount() - amount);
		transactonRepository.save(transaction);
		CurrentExistingAmount response = new CurrentExistingAmount(storedCard.getCardNumber(),
				request.getFollowUpCode(), ResponseStateEnum.SUCCESSFUL, account.getAmount());
		return response;

	}

	@PostMapping("/tenLastTransactions")
	@Transactional
	public Response getTenLastTransactions(@RequestBody Request request) {
		Card storedCard = cardRepository.findByCardNumber(request.getCardNumber());
		Set<Transaction> transactions = null;
		transactions = transactonRepository.getLastTenTransactions(storedCard.getCardNumber());
		CashFlowTranactionsResponse cashFlowTransactionResponse = new CashFlowTranactionsResponse(
				storedCard.getCardNumber(), request.getFollowUpCode(), ResponseStateEnum.SUCCESSFUL, transactions);
		double amount = fee(request.getTerminalType());
		Transaction transaction = new Transaction(new Date(), request.getTerminalType(), request.getFollowUpCode(),
				storedCard.getCardNumber(), amount, ResponseStateEnum.SUCCESSFUL.getCode());
		Account account = accountRepository.findByAccountNumber(storedCard.getMainAccount());
		account.setAmount(account.getAmount() - amount);
		transactonRepository.save(transaction);
		return cashFlowTransactionResponse;

	}


	@PostMapping("/getDailyTransactions")
	@Transactional
	public Response getDailyTransactions(@RequestBody DailyCashFlowTransactionRequest request) {
		Card storedCard = cardRepository.findByCardNumber(request.getCardNumber());
		Set<Transaction> transactions = transactonRepository.findAllByCardAndDate(storedCard.getCardNumber(),
				request.getStartDate(), request.getEndDate());
		double amount = fee(request.getTerminalType());
		Transaction transaction = new Transaction(new Date(), request.getTerminalType(), request.getFollowUpCode(),
				storedCard.getCardNumber(), amount, ResponseStateEnum.SUCCESSFUL.getCode());
		Account account = accountRepository.findByAccountNumber(storedCard.getMainAccount());
		account.setAmount(account.getAmount() - amount);
		transactonRepository.save(transaction);
		CashFlowTranactionsResponse response = new CashFlowTranactionsResponse(storedCard.getCardNumber(), request.getFollowUpCode(), ResponseStateEnum.SUCCESSFUL, transactions);
		return response;
	}

	@PostMapping("cartToCartTransaction")
	@Transactional
	public Response cartToCartTransaction(@RequestBody CartToCartTransactionRequest request) {
		Card sourceCard = cardRepository.findByCardNumber(request.getCardNumber());
		Card destinationCard = cardRepository.findByCardNumber(request.getDestinationCardNumber());
		Account sourceAccount = accountRepository.findByAccountNumber(sourceCard.getMainAccount());
		Account destinationAccount = accountRepository.findByAccountNumber(destinationCard.getMainAccount());
		Date date = new Date();
		Transaction sourceTransaction = new Transaction(date, request.getTerminalType(), request.getFollowUpCode(), sourceCard.getCardNumber(), -request.getAmount(), ResponseStateEnum.SUCCESSFUL.getCode());
		Transaction destinationTransaction = new Transaction(date, request.getTerminalType(), request.getFollowUpCode(), destinationCard.getCardNumber(), request.getAmount(), ResponseStateEnum.SUCCESSFUL.getCode());
		sourceAccount.setAmount(sourceAccount.getAmount() - request.getAmount());
		destinationAccount.setAmount(destinationAccount.getAmount() - request.getAmount());
		transactonRepository.save(sourceTransaction);
		transactonRepository.save(destinationTransaction);
		CartToCartTransactionResponse response = new CartToCartTransactionResponse(sourceCard.getCardNumber(), request.getFollowUpCode(), ResponseStateEnum.SUCCESSFUL, destinationCard.getCardNumber());
		return response;

	}
	
	private double fee(String terminalType) {
		double amount = 0;
		if (terminalType.equals(TerminalTypeEnum.ATM.getTerminalTypeCode()))
			amount = -5000;
		return amount;
	}

}
