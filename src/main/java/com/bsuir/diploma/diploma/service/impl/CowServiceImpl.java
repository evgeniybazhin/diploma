package com.bsuir.diploma.diploma.service.impl;

import com.bsuir.diploma.diploma.dao.CowRepository;
import com.bsuir.diploma.diploma.dao.FarmRepository;
import com.bsuir.diploma.diploma.domain.db.Farm;
import com.bsuir.diploma.diploma.domain.db.cattle.Cow;
import com.bsuir.diploma.diploma.service.CowService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CowServiceImpl implements CowService {
    @Autowired
    private CowRepository cowRepository;
    @Autowired
    private FarmRepository farmRepository;
    @Override
    public void addCow() {
        LocalDate date = LocalDate.now();
        Cow cow = Cow.builder()
                .birthday(date)
                .build();
        cowRepository.save(cow);
    }

    @Override
    public void updateCow(Cow cowToUpdate) {
        if (cowToUpdate != null) {
            Optional<Cow> cowOptional = cowRepository.findById(cowToUpdate.getId());
            if (cowOptional.isPresent()) {
                Cow cow = cowOptional.get();
                if (cowToUpdate.getHistoryVaccination() != null) {
                    if (cow.getHistoryVaccination() == null) {
                        cow.setHistoryVaccination("".concat(cowToUpdate.getHistoryVaccination()));
                    } else {
                        cow.setHistoryVaccination(cow
                                .getHistoryVaccination()
                                .concat(", ")
                                .concat(cowToUpdate.getHistoryVaccination()));
                    }
                }
                cow.setLastUpdateTime(LocalDateTime.now());
                cowRepository.save(cow);
            }
        }
    }

    @Override
    public void removeCow(Long id) {
        Optional<Cow> cow = cowRepository.findById(id);
        if (cow.isPresent()) {
            cowRepository.deleteById(id);
        }
    }
}
