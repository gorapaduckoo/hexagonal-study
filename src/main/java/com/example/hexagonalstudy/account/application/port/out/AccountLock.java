package com.example.hexagonalstudy.account.application.port.out;

import com.example.hexagonalstudy.account.domain.Account;

public interface AccountLock {

    void lockAccount(Account.AccountId accountId);

    void releaseAccount(Account.AccountId accountId);
}
