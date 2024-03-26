package com.example.hexagonalstudy.account.domain;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Optional;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Account {

    private final AccountId id;
    private final Money baselineBalance;
    private final ActivityWindow activityWindow;

    public static Account withoutId(Money baselineBalance, ActivityWindow activityWindow) {
        return new Account(null, baselineBalance, activityWindow);
    }

    public static Account withId(AccountId accountId, Money baselineBalance, ActivityWindow activityWindow) {
        return new Account(accountId, baselineBalance, activityWindow);
    }

    public Optional<AccountId> getId() {
        return Optional.ofNullable(this.id);
    }

    public Money calculateBalance() {
        return Money.add(
                this.baselineBalance,
                this.activityWindow.calculateBalance(this.id));
    }

    public boolean withdraw(Money money, AccountId targetAccountId) {

        if(!mayWithdraw(money)) {
            return false;
        }

        Activity withdrawl = new Activity(
                this.id,
                this.id,
                targetAccountId,
                LocalDateTime.now(),
                money);
        this.activityWindow.addActivity(withdrawl);
        return true;
    }

    private boolean mayWithdraw(Money money) {
        return Money.add(this.calculateBalance(), money.negate())
                .isPositiveOrZero();
    }
    @Value
    public static class AccountId {
        Long value;
    }
}
