package com.example.tradingaccountmanagementApplication.AccountBalance;

import javax.persistence.*;

@Entity(name = "AccountBalance")
public class AccountBalance {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private String accountId;

    @Column
    private double totalBalance;

    @Column
    private String walletName;

    public AccountBalance(String accountId, double totalBalance, String walletName) {
        this.accountId = accountId;
        this.totalBalance = totalBalance;
        this.walletName = walletName;
    }
}