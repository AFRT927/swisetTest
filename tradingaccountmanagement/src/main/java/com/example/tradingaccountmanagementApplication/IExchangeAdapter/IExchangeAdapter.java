package com.example.tradingaccountmanagementApplication.IExchangeAdapter;

import com.example.tradingaccountmanagementApplication.AccountBalance.AccountBalance;
import com.example.tradingaccountmanagementApplication.Trade.Trade;

import java.util.List;

public interface IExchangeAdapter {
    List<Trade> fetchTrades(List<String> accountIds);
    List<AccountBalance> fetchBalance(List<String> accountId);
}