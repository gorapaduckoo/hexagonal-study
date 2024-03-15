package com.example.hexagonalstudy.application.port.out;

import com.example.hexagonalstudy.domain.Account;

import java.time.LocalDateTime;

public interface LoadAccountPort {

    Account loadAccount(Account.AccountId accountId, LocalDateTime baselineDate);
}
