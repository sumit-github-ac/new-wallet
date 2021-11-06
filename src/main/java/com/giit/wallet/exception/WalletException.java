package com.giit.wallet.exception;

public class WalletException extends Exception {
    private String message;

    public WalletException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
}