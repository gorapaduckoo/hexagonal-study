package com.example.hexagonalstudy.account.application.port.out;

import com.example.hexagonalstudy.account.domain.Account;

public interface UpdateAccountStatePort {

    void updateActivities(Account account);
}
