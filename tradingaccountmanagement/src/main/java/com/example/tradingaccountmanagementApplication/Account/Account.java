package com.example.tradingaccountmanagementApplication.Account;
import javax.persistence.*;

@Entity(name = "Account")
public class Account {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private String accountId;
    @Column
    private String apiKey;
    @Column
    private String apiSecret;


    // Constructor con todos los campos
    public Account(String accountId, String apiKey, String apiSecret) {
        this.accountId = accountId;
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
    }

}
