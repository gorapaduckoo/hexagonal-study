package com.example.hexagonalstudy.application.service;

import com.example.hexagonalstudy.application.port.in.SendMoneyCommand;
import com.example.hexagonalstudy.application.port.in.SendMoneyUseCase;
import com.example.hexagonalstudy.application.port.out.AccountLock;
import com.example.hexagonalstudy.application.port.out.LoadAccountPort;
import com.example.hexagonalstudy.application.port.out.UpdateAccountStatePort;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
public class SendMoneyService implements SendMoneyUseCase {

    private final LoadAccountPort loadAccountPort;
    private final AccountLock accountLock;
    private final UpdateAccountStatePort updateAccoutStatePort;

    @Override
    public boolean sendMoney(SendMoneyCommand command) {
        // TODO: 비즈니스 규칙 검증
        // TODO: 모델 상태 조작
        // TODO: 출력 값 반환
        return false;
    }
}
