package com.example.tradingaccountmanagementApplication.TradeController;
import com.example.tradingaccountmanagementApplication.AccountBalance.AccountBalance;
import com.example.tradingaccountmanagementApplication.ITradeService.ITradeService;
import com.example.tradingaccountmanagementApplication.Trade.Trade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;



@RestController
public class TradeController {
    private final ITradeService tradeService;

    @Autowired
    public TradeController(ITradeService tradeService) {
        this.tradeService = tradeService;
    }


    @RequestMapping("/trades")
    public List<Trade> getTrades(@RequestParam List<String> accountIds) {
        List<Trade>  tradeList = tradeService.fetchTradesForAccounts(accountIds);
        return tradeList;
    }

    @RequestMapping("/balance")
    public List<AccountBalance> getbalance(@RequestParam List<String> accountIds) {
        List<AccountBalance> balanceList = tradeService.fetchAccountBalance(accountIds);
        return balanceList;
    }


}





