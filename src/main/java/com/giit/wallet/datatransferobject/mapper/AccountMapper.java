package com.giit.wallet.datatransferobject.mapper;

import com.giit.wallet.dataobject.Account;
import com.giit.wallet.datatransferobject.AccountDTO;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


public class AccountMapper {

    public static Account dtoToDO(AccountDTO a) {
        Account account = new Account.AccountBuilder()
                .setDateCreated(new Date())
                .setId(a.getId())
                .setUserName(a.getUserName())
                .setSex(a.getSex())
                .build();
        return account;
    }

    public static AccountDTO doToDTO(Account a) {
        double balance = a.getTransactions().stream().mapToDouble(o -> o.getAmount().doubleValue()).sum();
        AccountDTO dto = new AccountDTO.AccountDTOBuilder().setId(a.getId())
                .setDateCreated(a.getDateCreated())
                .setUserName(a.getUserName())
                .setId(a.getId())
                .setSex(a.getSex())
                .setBalance(new BigDecimal(balance))
                .build();
        return dto;
    }

    public static List<AccountDTO> doToDTOList(List<Account> account) {
        return account.stream()
                .map(AccountMapper::doToDTO)
                .collect(Collectors.toList());
    }

}
