package com.example.hexagonalstudy.account.application.port.out;

import com.example.hexagonalstudy.account.domain.Account;

import java.time.LocalDateTime;

public interface LoadAccountPort {

    Account loadAccount(Account.AccountId accountId, LocalDateTime baselineDate);
}
