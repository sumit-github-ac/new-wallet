package com.giit.wallet.datatransferobject.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.giit.wallet.dataobject.Wallet;
import com.giit.wallet.datatransferobject.WalletDTO;

public class WalletMapper {

    public static Wallet dtoToDO(WalletDTO w) {
        Wallet wallet = new Wallet.WalletBuilder()
                .setAccount(w.getAccountId())
                .setAmount(w.getAmount())
                .setId(w.getId())
                .setPurpose(w.getPurpose())
                .setTransactionDate(w.getTransactionDate())
                .setTransactionReference(w.getTransactionReference()).build();
        return wallet;
    }

    public static WalletDTO doToDTO(Wallet w) {
        WalletDTO walletDTO = new WalletDTO.WalletDTOBuilder()
                .setAccountId(w.getAccount().getId())
                .setAmount(w.getAmount())
                .setId(w.getId())
                .setPurpose(w.getPurpose())
                .setTransactionDate(w.getTransactionDate())
                .setTransactionReference(w.getTransactionReference()).build();
        return walletDTO;
    }

    public static List<WalletDTO> doToDTOList(List<Wallet> txns) {
        return txns.stream()
                .map(WalletMapper::doToDTO)
                .collect(Collectors.toList());
    }
}
