package com.bsuir.diploma.diploma.controller;

import com.bsuir.diploma.diploma.converter.ObjectConverter;
import com.bsuir.diploma.diploma.dao.FieldRepository;
import com.bsuir.diploma.diploma.domain.db.Field;
import com.bsuir.diploma.diploma.domain.db.dto.FieldDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/fields")
@RequiredArgsConstructor
public class FieldController {
    @Autowired
    private ObjectConverter objectConverter;
    @Autowired
    private FieldRepository fieldRepository;

    @GetMapping(value = "/user")
    public String getFieldPage(Model model) {
        model.addAttribute("fields", fieldRepository.findAll());
        model.addAttribute("field", new FieldDto());
        return "/views/user/field";
    }

    @PostMapping(value = "/update")
    public String updateStatus(@ModelAttribute("field") FieldDto fieldDto) {
        Field field = (Field) objectConverter.parse(fieldDto);
        fieldRepository.save(field);
        return "/views/user/field";
    }
}
