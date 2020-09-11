package com.bsuir.diploma.diploma.service.impl;

import com.bsuir.diploma.diploma.dao.CowRepository;
import com.bsuir.diploma.diploma.dao.MilkRepository;
import com.bsuir.diploma.diploma.domain.db.cattle.Cow;
import com.bsuir.diploma.diploma.domain.db.products.Milk;
import com.bsuir.diploma.diploma.domain.db.dto.MilkDto;
import com.bsuir.diploma.diploma.service.MilkService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MilkServiceImpl implements MilkService {
    @Autowired
    private MilkRepository milkRepository;
    @Autowired
    private CowRepository cowRepository;
    @Override
    public void addMilk(MilkDto milkDto) {
        Optional<Cow> cow = cowRepository.findById(milkDto.getId());
        Double countMilk = milkDto.getCountOfMilk();
        LocalDateTime now = LocalDateTime.now();
        Milk milk = null;
        if (cow.isPresent()) {
            milk = Milk.builder()
                    .count(countMilk)
                    .cowId(cow.get())
                    .build();
        }
        milkRepository.save(milk);
    }
}
