package com.bsuir.diploma.diploma.job.impl;

import com.bsuir.diploma.diploma.dao.MilkInDayRepository;
import com.bsuir.diploma.diploma.dao.MilkWeekRepository;
import com.bsuir.diploma.diploma.domain.db.products.MilkInDay;
import com.bsuir.diploma.diploma.domain.db.products.MilkInWeek;
import com.bsuir.diploma.diploma.job.CronJobTrigger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MilkWeekComputationJob implements Runnable, CronJobTrigger {
    @Autowired
    private MilkInDayRepository milkInDayRepository;
    @Autowired
    private MilkWeekRepository milkWeekRepository;

    @Override
    public void run() {
        new Thread(new MilkWeekComputationJob.MilkWeekComputationRunnable()).start();
    }

    private void computation() {
        LocalDate localDate = LocalDate.now();
        List<MilkInDay> milkInDays = milkInDayRepository.findAllByDayAfter(localDate.minusDays(7));
        Double milkInWeek = null;
        if (milkInDays != null && !milkInDays.isEmpty()) {
            for (MilkInDay milk : milkInDays) {
                milkInWeek += milk.getCount();
            }
            MilkInWeek milk = MilkInWeek.builder()
                    .count(milkInWeek)
                    .date(localDate)
                    .build();
            milkWeekRepository.save(milk);
        }
    }

    private class MilkWeekComputationRunnable implements Runnable {
        @Override
        public void run() {
            computation();
        }
    }
}
