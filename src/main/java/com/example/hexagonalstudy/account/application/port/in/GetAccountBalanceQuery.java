package com.example.hexagonalstudy.account.application.port.in;

import com.example.hexagonalstudy.account.domain.Account;
import com.example.hexagonalstudy.account.domain.Money;

public interface GetAccountBalanceQuery {

    Money getAccountBalanceQuery(Account.AccountId accountId);

}
