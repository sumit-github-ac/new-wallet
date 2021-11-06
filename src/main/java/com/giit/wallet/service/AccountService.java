package com.giit.wallet.service;

import com.giit.wallet.dataobject.Account;
import com.giit.wallet.exception.WalletException;

public interface AccountService extends  UserService<Account> {
	   Account accountByPK(Long accountId) throws WalletException;
	}