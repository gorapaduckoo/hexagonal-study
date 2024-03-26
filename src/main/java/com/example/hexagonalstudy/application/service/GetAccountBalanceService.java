package com.example.hexagonalstudy.application.service;

import com.example.hexagonalstudy.application.port.in.GetAccountBalanceQuery;
import com.example.hexagonalstudy.application.port.out.LoadAccountPort;
import com.example.hexagonalstudy.domain.Account;
import com.example.hexagonalstudy.domain.Money;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
public class GetAccountBalanceService implements GetAccountBalanceQuery {

    private final LoadAccountPort loadAccountPort;

    @Override
    public Money getAccountBalanceQuery(Account.AccountId accountId) {
        return loadAccountPort.loadAccount(accountId, LocalDateTime.now())
                .calculateBalance();
    }
}
