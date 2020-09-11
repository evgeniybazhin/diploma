package com.bsuir.diploma.diploma.job.impl;

import com.bsuir.diploma.diploma.dao.MilkInDayRepository;
import com.bsuir.diploma.diploma.dao.MilkRepository;
import com.bsuir.diploma.diploma.domain.db.products.Milk;
import com.bsuir.diploma.diploma.domain.db.products.MilkInDay;
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
public class MilkDayCountingJob implements Runnable, CronJobTrigger {

    @Autowired
    private MilkRepository milkRepository;
    @Autowired
    private MilkInDayRepository milkInDayRepository;

    @Override
    @Scheduled(cron = "${}")
    public void run() {
        new Thread(new MilkDayCountingJob.MilkDayCountingRunnable()).start();
    }

    private void computation() {
        LocalDate date = LocalDate.now();
        List<Milk> milkList = milkRepository.findAllByCreationTimeAfter(LocalDateTime.now().minusDays(1));
        Double countMilkADay = null;
        if (milkList != null && !milkList.isEmpty()) {
            for (Milk milk : milkList) {
                countMilkADay += milk.getCount();
            }
            MilkInDay milkInDay = MilkInDay.builder()
                    .count(countMilkADay)
                    .day(date)
                    .build();
            milkInDayRepository.save(milkInDay);
        }
    }

    private class MilkDayCountingRunnable implements Runnable {

        @Override
        public void run() {
            computation();
        }
    }
}
