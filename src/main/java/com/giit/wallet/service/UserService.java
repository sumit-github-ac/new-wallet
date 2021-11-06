package com.giit.wallet.service;

import java.util.List;

import com.giit.wallet.exception.WalletException;

public interface UserService<T> {
    T save(T t) throws WalletException;
    T update(T t,Long id) throws WalletException ;
    List<T> getList();
}