package com.example.tradingaccountmanagementApplication.TradeRepository;
import com.example.tradingaccountmanagementApplication.Trade.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@Repository
public interface TradeRepository extends JpaRepository<Trade, Long> {
    // Custom database queries if needed

}
