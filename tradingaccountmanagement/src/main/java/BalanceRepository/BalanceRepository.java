package BalanceRepository;
import com.example.tradingaccountmanagementApplication.AccountBalance.AccountBalance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface BalanceRepository extends JpaRepository<AccountBalance, Long> {
    // Custom database queries if needed

}
