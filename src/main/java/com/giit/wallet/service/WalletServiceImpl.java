package com.giit.wallet.service;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giit.wallet.dataaccessobject.WalletRepository;
import com.giit.wallet.dataobject.Wallet;
import com.giit.wallet.exception.InsufficientBalanceException;
import com.giit.wallet.exception.WalletException;
import com.google.common.collect.Lists;

@Service
@Transactional
public class WalletServiceImpl implements WalletService {

	@Autowired
	private WalletRepository walletRepository;
	@Autowired
	private AccountService accountService;

	/**
	 * retrieve transactions by their transaction reference this operations is used
	 * to validate if a transaction ref has been used previously
	 */
	@Override
	public Wallet transactionByRef(Long txnRef) throws WalletException {
		return walletRepository.getTransactionByRef(txnRef).orElseThrow(
				() -> new WalletException(String.format("transaction with ref '%d' doesnt exist", txnRef)));
	}

	/**
	 * this operations registers a transaction on behalf of user debit/credits, it
	 * also validates if a user has insufficient funds if a debit is to be made
	 */
	@Override
	@Transactional
	public Wallet createTransaction(Wallet wallet) throws WalletException, InsufficientBalanceException {
		// checks for transaction ref to ensure its uniqueness
		if (walletRepository.getTransactionByRef(wallet.getTransactionReference()).isPresent()) {
			throw new WalletException("transaction ref has been used ");
		}
		BigDecimal balance = walletRepository.getBalance(wallet.getAccount().getId());

		if (balance.add(wallet.getAmount()).compareTo(BigDecimal.ZERO) == 1
				| balance.add(wallet.getAmount()).compareTo(BigDecimal.ZERO) == 0) {
			return walletRepository.save(wallet);
		}

		throw new InsufficientBalanceException(
				String.format("user's balance is %.2f and cannot perform a transaction of %.2f ",
						balance.doubleValue(), wallet.getAmount().doubleValue()));

	}

	@Override
	public Wallet update(Wallet wallet, Long id) throws WalletException {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public List<Wallet> getList() {
		return Lists.newArrayList(walletRepository.findAll());
	}

	@Override
	public List<Wallet> transactionsByAccountID(Long accountId) {
		return walletRepository.getTransactionsForUser(accountId);
	}

	@Override
	public BigDecimal balanceByAccountID(Long accountId) {
		return walletRepository.getBalance(accountId);
	}

	@Override
	public List<Wallet> transactions() {
		return Lists.newArrayList(walletRepository.findAll());
	}

	@Override
	public Wallet save(Wallet wallet) throws WalletException {
		throw new UnsupportedOperationException("Not supported yet.");
	}

}
