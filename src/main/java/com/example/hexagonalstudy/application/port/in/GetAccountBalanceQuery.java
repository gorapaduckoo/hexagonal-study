package com.example.hexagonalstudy.application.port.in;

import com.example.hexagonalstudy.domain.Account;
import com.example.hexagonalstudy.domain.Money;

public interface GetAccountBalanceQuery {

    Money getAccountBalanceQuery(Account.AccountId accountId);

}
