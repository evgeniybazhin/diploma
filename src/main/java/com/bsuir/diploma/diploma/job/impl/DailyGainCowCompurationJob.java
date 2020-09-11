package com.bsuir.diploma.diploma.job.impl;

import com.bsuir.diploma.diploma.dao.CowRepository;
import com.bsuir.diploma.diploma.dao.DailyGainCowRepository;
import com.bsuir.diploma.diploma.domain.db.DailyGainCow;
import com.bsuir.diploma.diploma.domain.db.cattle.Cow;
import com.bsuir.diploma.diploma.job.CronJobTrigger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DailyGainCowCompurationJob implements Runnable, CronJobTrigger {
    @Autowired
    private CowRepository cowRepository;
    @Autowired
    private DailyGainCowRepository dailyGainCowRepository;
    @Override
    @Scheduled()
    public void run() {
        new Thread(new DailyGainCowCompurationJob.DailyGainCowRunnable()).start();
    }

    private class DailyGainCowRunnable implements Runnable {
        @Override
        public void run() {
            List<Cow> cowList = cowRepository.findAllByBirthdayAfter(LocalDate.now().minusDays(1));
            Integer countToday = null;
            if (cowList.isEmpty()) {
                countToday = 0;
            } else {
                countToday = cowList.size();
            }
            dailyGainCowRepository.save(DailyGainCow.builder()
                    .gain(countToday)
                    .build());
        }
    }
}
