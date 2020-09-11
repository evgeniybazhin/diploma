package com.bsuir.diploma.diploma.converter.impl;

import com.bsuir.diploma.diploma.converter.ObjectConverter;
import com.bsuir.diploma.diploma.domain.db.Field;
import com.bsuir.diploma.diploma.domain.db.FieldStatus;
import com.bsuir.diploma.diploma.domain.db.dto.FieldDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FieldConverter implements ObjectConverter<FieldDto, Field> {

    @Override
    public Field parse(FieldDto fieldDto) {
        String location = fieldDto.getLocation();
        FieldStatus fieldStatus = FieldStatus.valueOf(fieldDto.getStatus());
        return Field.builder()
                .location(location)
                .fieldStatus(fieldStatus)
                .build();
    }
}
