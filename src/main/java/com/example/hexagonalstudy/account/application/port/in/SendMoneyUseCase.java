package com.example.hexagonalstudy.account.application.port.in;

public interface SendMoneyUseCase {

    boolean sendMoney(SendMoneyCommand command);
}
