package com.example.tradingaccountmanagementApplication.BinanceAdapter;

import BalanceRepository.BalanceRepository;
import com.example.tradingaccountmanagementApplication.IExchangeAdapter.IExchangeAdapter;
import com.example.tradingaccountmanagementApplication.AccountBalance.AccountBalance;
import com.example.tradingaccountmanagementApplication.Account.Account;
import com.example.tradingaccountmanagementApplication.Trade.Trade;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import com.binance.connector.client.SpotClient;
import com.binance.connector.client.impl.SpotClientImpl;
import java.util.List;
import org.json.JSONArray;
import com.example.tradingaccountmanagementApplication.TradeRepository.TradeRepository;

@Component
public class BinanceAdapter implements IExchangeAdapter {


    private TradeRepository tradeRepo;
    private BalanceRepository balanceRepo;
    String BINANCE_API_KEY = "WtTiglW0UshTIbZpaVHcfIvILcH7n07DyFG28M4rFJJfV0vxK6XM5uthKnWy3e9f";
    String BINANCE_SECRET_KEY = "Ui4eNjl0OWHoHIGFTuWONxCdNqpsJrZdzd3XSjnZOpU3vbPiNxX1rWrQpULNTpix";
    SpotClient client = new SpotClientImpl(BINANCE_API_KEY, BINANCE_SECRET_KEY, "https://api.binance.com");


    @Override
    public List<Trade> fetchTrades(List<String> accountIds) {        // Implement API calls to Binance

        Map<String, Object> parameters = new LinkedHashMap<>();
        parameters.put("symbol", "BTCUSDT");
        parameters.put("limit", "10");
        String tradeListRes = client.createTrade().myTrades(parameters);
        System.out.println(tradeListRes);

        JSONArray jsonResult = new JSONArray(tradeListRes);

        List<Trade> tradeList = new ArrayList<Trade>();
        for (int a = 0; a < accountIds.size(); a++) {
            for (int i = 0; i < jsonResult.length(); i++) {
                JSONObject o = jsonResult.getJSONObject(i);
                tradeList.add(
                    new Trade(
                            o.getLong("orderId"),
                            Double.valueOf(o.getString("price")),
                            Double.valueOf(o.getString("qty")),
                            o.getLong("time"),
                            o.getString("symbol"),
                            accountIds.get(a)
                    )
                );
            }
        }

        //tradeRepo.saveAll(tradeList);

        return tradeList;
    }


    @Override
    public List<AccountBalance> fetchBalance(List<String> accountIds) {
        // Implement API calls to Binance
        Map<String, Object> parameters = new LinkedHashMap<>();
        String balanceListRes = client.createWallet().walletBalance(parameters);
        JSONArray jsonResult = new JSONArray(balanceListRes);
        System.out.println(jsonResult);

        List<AccountBalance> balanceList = new ArrayList<AccountBalance>();
        for (int a = 0; a < accountIds.size(); a++) {
            for (int i = 0; i < jsonResult.length(); i++) {
                JSONObject o = jsonResult.getJSONObject(i);
                System.out.println("accountIDs " + accountIds.get(0));
                balanceList.add(
                    new AccountBalance(
                            accountIds.get(a),
                            Double.valueOf(o.getString("balance")),
                            o.getString("walletName")
                    )
                );
            }
        }

        //balanceRepo.saveAll(balanceList);

        return balanceList;
    }
}