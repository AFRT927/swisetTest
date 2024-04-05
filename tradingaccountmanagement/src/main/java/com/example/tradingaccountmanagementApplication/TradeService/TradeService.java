package com.example.tradingaccountmanagementApplication.TradeService;

import com.example.tradingaccountmanagementApplication.IExchangeAdapter.IExchangeAdapter;
import com.example.tradingaccountmanagementApplication.ITradeService.ITradeService;
import com.example.tradingaccountmanagementApplication.AccountBalance.AccountBalance;
import com.example.tradingaccountmanagementApplication.Trade.Trade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TradeService implements ITradeService {
    private final IExchangeAdapter exchangeAdapter;

    @Autowired
    public TradeService(IExchangeAdapter exchangeAdapter) {
        this.exchangeAdapter = exchangeAdapter;
    }

    @Override
    public List<Trade> fetchTradesForAccounts(List<String> accountIds) {
        return exchangeAdapter.fetchTrades(accountIds);
    }

    @Override
    public List<AccountBalance> fetchAccountBalance(List<String> accountId) {
        return exchangeAdapter.fetchBalance(accountId);
    }
}