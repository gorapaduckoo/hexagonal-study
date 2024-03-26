package com.example.hexagonalstudy.account.application.port.in;

import com.example.hexagonalstudy.common.SelfValidationg;
import com.example.hexagonalstudy.account.domain.Account;
import com.example.hexagonalstudy.account.domain.Money;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = false)
public class SendMoneyCommand extends SelfValidationg<SendMoneyCommand> {

    @NotNull
    private final Account.AccountId sourceAccountId;
    @NotNull
    private final Account.AccountId targetAccountId;
    @NotNull
    private final Money money;

    public SendMoneyCommand(Account.AccountId sourceAccountId, Account.AccountId targetAccountId, Money money) {
        this.sourceAccountId = sourceAccountId;
        this.targetAccountId = targetAccountId;
        this.money = money;
        requireGreaterThan(money, 0);
        this.validateSelf();
    }

    private void requireGreaterThan(Money money, int amount) {
        // Validate money is greater than amount
    }
}
