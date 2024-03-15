package com.example.hexagonalstudy.application.port.out;

import com.example.hexagonalstudy.domain.Account;

public interface AccountLock {

    void lockAccount(Account.AccountId accountId);

    void releaseAccount(Account.AccountId accountId);
}
