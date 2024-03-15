package com.example.hexagonalstudy.application.port.out;

import com.example.hexagonalstudy.domain.Account;

public interface UpdateAccountStatePort {

    void updateActivities(Account account);
}
