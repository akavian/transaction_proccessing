package com.dotin.interview.transaction.processing.controller;

import com.dotin.interview.transaction.processing.enums.ResponseStateEnum;
import com.dotin.interview.transaction.processing.model.Account;
import com.dotin.interview.transaction.processing.model.Card;
import com.dotin.interview.transaction.processing.model.Transaction;
import com.dotin.interview.transaction.processing.repository.AccountRepository;
import com.dotin.interview.transaction.processing.repository.CardRepository;
import com.dotin.interview.transaction.processing.repository.TransactionRepository;
import com.dotin.interview.transaction.processing.request.CartToCartTransactionRequest;
import com.dotin.interview.transaction.processing.request.DailyCashFlowTransactionRequest;
import com.dotin.interview.transaction.processing.request.DefaultRequest;
import com.dotin.interview.transaction.processing.response.CartToCartTransactionResponse;
import com.dotin.interview.transaction.processing.response.CashFlowTranactionsResponse;
import com.dotin.interview.transaction.processing.response.CurrentExistingAmount;
import com.dotin.interview.transaction.processing.response.DefaultResponse;
import com.dotin.interview.transaction.processing.strategy.ValidationContext;
import com.dotin.interview.transaction.processing.validator.CarToCartTransactionValidationStrategyImpl;
import com.dotin.interview.transaction.processing.validator.DailyCashFlowTransactionValidationStrategyImpl;
import com.dotin.interview.transaction.processing.validator.DefaultRequestValidationStrategyImpl;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.Set;


@RestController
@RequestMapping("/mainTransactions")
public class TransactionManager {

	private final WebApplicationContext context;
	private final int amount = -1000;

	public TransactionManager(WebApplicationContext context) {
		this.context = context;
	}

	@PostMapping("/existingAmount")
	@Transactional
	public DefaultResponse getExistingAmount(@RequestBody DefaultRequest request) {

		ValidationContext validationContext = new ValidationContext(context.getBean(DefaultRequestValidationStrategyImpl.class));
		validationContext.validate(request);
		Card storedCard = context.getBean(CardRepository.class).findByCardNumber(request.getCardNumber());
		Transaction transaction = new Transaction(new Date(), request.getTerminalType(), request.getFollowUpCode(),
				storedCard.getCardNumber(), 0, ResponseStateEnum.SUCCESSFUL.getCode());
		Account account = context.getBean(AccountRepository.class).findByAccountNumber(storedCard.getMainAccount());
		context.getBean(TransactionRepository.class).save(transaction);
		CurrentExistingAmount response = new CurrentExistingAmount(storedCard.getCardNumber(),
				request.getFollowUpCode(), ResponseStateEnum.SUCCESSFUL, account.getAmount());
		context.getBean(TransactionRepository.class).save(transaction);

		return response;

	}

	@PostMapping("/tenLastTransactions")
	@Transactional
	public DefaultResponse getTenLastTransactions(@RequestBody DefaultRequest request) {

		ValidationContext validationContext = new ValidationContext(context.getBean(DefaultRequestValidationStrategyImpl.class));
		validationContext.validate(request);

		Card storedCard = context.getBean(CardRepository.class).findByCardNumber(request.getCardNumber());
		Set<Transaction> transactions = context.getBean(TransactionRepository.class).getLastTenTransactions(storedCard.getCardNumber());
		CashFlowTranactionsResponse cashFlowTransactionResponse = new CashFlowTranactionsResponse(
				storedCard.getCardNumber(), request.getFollowUpCode(), ResponseStateEnum.SUCCESSFUL, transactions);
		Transaction transaction = new Transaction(new Date(), request.getTerminalType(), request.getFollowUpCode(),
				storedCard.getCardNumber(), 0, ResponseStateEnum.SUCCESSFUL.getCode());
		context.getBean(TransactionRepository.class).save(transaction);
		return cashFlowTransactionResponse;

	}


	@PostMapping("/getDailyTransactions")
	@Transactional
	public DefaultResponse getDailyTransactions(@RequestBody DailyCashFlowTransactionRequest request) {
		ValidationContext validationContext = new ValidationContext(context.getBean(DailyCashFlowTransactionValidationStrategyImpl.class));
		validationContext.validate(request);
		Card storedCard = context.getBean(CardRepository.class).findByCardNumber(request.getCardNumber());
		Set<Transaction> transactions = context.getBean(TransactionRepository.class).findAllByCardAndDate(storedCard.getCardNumber(),
				request.getStartDate(), request.getEndDate());
		Transaction transaction = new Transaction(new Date(), request.getTerminalType(), request.getFollowUpCode(),
				storedCard.getCardNumber(), amount, ResponseStateEnum.SUCCESSFUL.getCode());
		Account account = context.getBean(AccountRepository.class).findByAccountNumber(storedCard.getMainAccount());
		account.setAmount(account.getAmount() - amount);
		context.getBean(TransactionRepository.class).save(transaction);
		CashFlowTranactionsResponse response = new CashFlowTranactionsResponse(storedCard.getCardNumber(), request.getFollowUpCode(), ResponseStateEnum.SUCCESSFUL, transactions);
		return response;
	}

	@PostMapping("cartToCartTransaction")
	@Transactional
	public DefaultResponse cartToCartTransaction(@RequestBody CartToCartTransactionRequest request) {
		ValidationContext validationContext = new ValidationContext(context.getBean(CarToCartTransactionValidationStrategyImpl.class));
		validationContext.validate(request);
		CardRepository cardRepository = context.getBean(CardRepository.class);
		Card sourceCard = cardRepository.findByCardNumber(request.getCardNumber());
		Card destinationCard = cardRepository.findByCardNumber(request.getDestinationCardNumber());

		AccountRepository accountRepository = context.getBean(AccountRepository.class);
		Account sourceAccount = accountRepository.findByAccountNumber(sourceCard.getMainAccount());
		Account destinationAccount = accountRepository.findByAccountNumber(destinationCard.getMainAccount());
		Date date = new Date();
		Transaction sourceTransaction = new Transaction(date, request.getTerminalType(), request.getFollowUpCode(), sourceCard.getCardNumber(), -request.getAmount() + amount, ResponseStateEnum.SUCCESSFUL.getCode());
		Transaction destinationTransaction = new Transaction(date, request.getTerminalType(), request.getFollowUpCode(), destinationCard.getCardNumber(), request.getAmount(), ResponseStateEnum.SUCCESSFUL.getCode());
		sourceAccount.setAmount(sourceAccount.getAmount() - request.getAmount());
		destinationAccount.setAmount(destinationAccount.getAmount() - request.getAmount());

		TransactionRepository transactionRepository = context.getBean(TransactionRepository.class);
		transactionRepository.save(sourceTransaction);
		transactionRepository.save(destinationTransaction);
		CartToCartTransactionResponse response = new CartToCartTransactionResponse(sourceCard.getCardNumber(), request.getFollowUpCode(), ResponseStateEnum.SUCCESSFUL, destinationCard.getCardNumber());
		return response;

	}


}
