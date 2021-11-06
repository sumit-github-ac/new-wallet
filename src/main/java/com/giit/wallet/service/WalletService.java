package com.giit.wallet.service;

import java.math.BigDecimal;
import java.util.List;

import com.giit.wallet.dataobject.Wallet;
import com.giit.wallet.exception.InsufficientBalanceException;
import com.giit.wallet.exception.WalletException;

public interface WalletService extends UserService<Wallet>{
    List<Wallet> transactionsByAccountID(Long accountId)  throws WalletException;
    Wallet transactionByRef(Long txnRef)  throws WalletException;
    /**
     *
     * @param accountId
     * @return
     * @throws com.giit.wallet.exception.WalletException
     */
    BigDecimal balanceByAccountID(Long accountId)  throws WalletException;
    List<Wallet> transactions();
    Wallet createTransaction(Wallet wallet) throws WalletException,InsufficientBalanceException;
}