package com.example.hexagonalstudy.account.adapter.out.persistence;

import com.example.hexagonalstudy.account.application.port.out.LoadAccountPort;
import com.example.hexagonalstudy.account.application.port.out.UpdateAccountStatePort;
import com.example.hexagonalstudy.account.domain.Account;
import com.example.hexagonalstudy.account.domain.Account.AccountId;
import com.example.hexagonalstudy.account.domain.Activity;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Component
public class AccountPersistenceAdapter implements LoadAccountPort, UpdateAccountStatePort {

    private final AccountRepository accountRepository;
    private final ActivityRepository activityRepository;
    private final AccountMapper accountMapper;

    @Override
    public Account loadAccount(AccountId accountId, LocalDateTime baselineDate) {
        AccountJpaEntity account = accountRepository.findById(accountId.getValue())
                .orElseThrow(EntityNotFoundException::new);

        List<ActivityJpaEntity> activities = activityRepository.findByOwnerSince(account.getId(), baselineDate);

        Long withdrawalalance = orZero(activityRepository.getWithdrawalBalanceUntil(account.getId(), baselineDate));

        Long depositBalance = orZero(activityRepository.getDepositBalanceUntil(account.getId(), baselineDate));

        return accountMapper.mapToDomainEntity(account, activities, withdrawalalance, depositBalance);

    }

    private Long orZero(Long value) {
        return value == null ? 0L : value;
    }

    @Override
    public void updateActivities(Account account) {
        for (Activity activity : account.getActivityWindow().getActivities()) {
            if (activity.getId() == null) {
                activityRepository.save(accountMapper.mapToJpaEntity(activity));
            }
        }
    }
}
