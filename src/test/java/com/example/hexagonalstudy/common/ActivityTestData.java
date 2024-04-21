package com.example.hexagonalstudy.common;

import com.example.hexagonalstudy.account.domain.Account;
import com.example.hexagonalstudy.account.domain.Account.AccountId;
import com.example.hexagonalstudy.account.domain.Activity;
import com.example.hexagonalstudy.account.domain.Activity.ActivityId;
import com.example.hexagonalstudy.account.domain.Money;

import java.time.LocalDateTime;


public class ActivityTestData {

    public static ActivityBuilder defaultActivity() {
        return new ActivityBuilder()
                .withOwnerAccount(new AccountId(42L))
                .withSourceAccount(new AccountId(42L))
                .withTargetAccount(new AccountId(41L))
                .withTimestamp(LocalDateTime.now())
                .withMoney(Money.of(999L));
    }

    public static class ActivityBuilder {
        private Activity.ActivityId id;
        private Account.AccountId ownerAccountId;
        private AccountId sourceAccountId;
        private AccountId targetAccountId;
        private LocalDateTime timestamp;
        private Money money;

        public ActivityBuilder withId(ActivityId id) {
            this.id = id;
            return this;
        }

        public ActivityBuilder withOwnerAccount(AccountId accountId) {
            this.ownerAccountId = accountId;
            return this;
        }

        public ActivityBuilder withSourceAccount(AccountId accountId) {
            this.sourceAccountId = accountId;
            return this;
        }

        public ActivityBuilder withTargetAccount(AccountId accountId) {
            this.targetAccountId = accountId;
            return this;
        }

        public ActivityBuilder withTimestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public ActivityBuilder withMoney(Money money) {
            this.money = money;
            return this;
        }

        public Activity build() {
            return new Activity(
                    this.id,
                    this.ownerAccountId,
                    this.sourceAccountId,
                    this.targetAccountId,
                    this.timestamp,
                    this.money
            );
        }
    }
}
