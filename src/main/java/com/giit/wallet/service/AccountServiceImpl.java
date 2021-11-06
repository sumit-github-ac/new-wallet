package com.giit.wallet.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import com.giit.wallet.dataaccessobject.AccountRepository;
import com.giit.wallet.dataobject.Account;
import com.giit.wallet.exception.WalletException;
import com.google.common.collect.Lists;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account accountByPK(Long accountId) throws WalletException {
        return accountRepository.findById(accountId).
                orElseThrow(() -> new WalletException(String.format("account with '%d' not found ", accountId)));
    }

    /**
     * this operations registers a user and creates and account for him/her
     * with minimal details     
     */
    @Override
    @Transactional
    public Account save(Account account) throws WalletException {
        if (account.getUserName() != null) {
            if (account.getUserName().length() < 5) {
                throw new WalletException("user name is should be 5 characters of more");
            }
            return accountRepository.save(account);
        }
        throw new WalletException("user name is mandatory");
    }

    /**
     * this operation updates a users account information
     * and checks for concurrent user modification
     */
    @Override
    @Transactional
    public Account update(Account account, Long accountId) throws WalletException {
        if (account.getUserName() != null) {
            account.setId(accountId);
            try {
                return accountRepository.save(account);
            } catch (ObjectOptimisticLockingFailureException e) {
                throw new WalletException("refresh your page to get updated users");
            }
        }
        throw new WalletException("user name is mandatory");

    }

    /**
     * this operation gets all account lists and their respective 
     * wallet transactions 
     */
    @Override
    public List<Account> getList() {
        return Lists.newArrayList(accountRepository.findAll());
    }

}
