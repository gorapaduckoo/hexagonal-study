package com.example.hexagonalstudy.account.application.service;

import com.example.hexagonalstudy.account.domain.Money;

public class ThresholdExceededException extends RuntimeException {

    public ThresholdExceededException(Money threshold, Money actual) {
        super(String.format("Maximum threshold for transferring money eeded: tried to transfer %s but threshold is %s!", actual, threshold));
    }
}
