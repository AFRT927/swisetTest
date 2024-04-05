package com.example.tradingaccountmanagementApplication.Trade;
import javax.persistence.*;

@Entity(name = "Trade")
public class Trade {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long orderId;
    @Column
    private double price;
    @Column
    private double qty;
    @Column
    private long time;
    @Column
    private String symbol;
    @Column
    private String accountId;

    // Constructor con todos los campos
    public Trade(long orderId, double price, double qty, long time, String symbol, String accountId) {
        this.orderId = orderId;
        this.price = price;
        this.qty = qty;
        this.time = time;
        this.symbol = symbol;
        this.accountId = accountId;
    }

}
