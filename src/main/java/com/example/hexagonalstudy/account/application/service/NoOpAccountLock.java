package com.example.hexagonalstudy.account.application.service;

import com.example.hexagonalstudy.account.application.port.out.AccountLock;
import com.example.hexagonalstudy.account.domain.Account;
import org.springframework.stereotype.Component;

@Component
public class NoOpAccountLock implements AccountLock {


    @Override
    public void lockAccount(Account.AccountId accountId) {
        // do nothing
    }

    @Override
    public void releaseAccount(Account.AccountId accountId) {
        // do nothing
    }
}
