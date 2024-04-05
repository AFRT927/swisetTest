package com.example.tradingaccountmanagementApplication.ITradeService;

import com.example.tradingaccountmanagementApplication.AccountBalance.AccountBalance;
import com.example.tradingaccountmanagementApplication.Trade.Trade;

import java.util.List;

public interface ITradeService {
    List<Trade> fetchTradesForAccounts(List<String> accountIds);
    List<AccountBalance> fetchAccountBalance(List<String> accountIds);
}