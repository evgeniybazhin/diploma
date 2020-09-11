package com.bsuir.diploma.diploma.controller;

import com.bsuir.diploma.diploma.domain.db.dto.MilkDto;
import com.bsuir.diploma.diploma.service.MilkService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/milk")
@AllArgsConstructor
public class MilkController {

    @Autowired
    private MilkService milkService;

    @GetMapping
    public String getMilkPage(Model model) {
        model.addAttribute("milk", new MilkDto());
        return "/views/user/milk";
    }

    @PostMapping
    public String addMilkCow(@ModelAttribute("milk") MilkDto milkDto) {
        milkService.addMilk(milkDto);
        return "redirect:/user/milk";
    }
}
