package com.bsuir.diploma.diploma.controller;

import com.bsuir.diploma.diploma.dao.BullRepository;
import com.bsuir.diploma.diploma.dao.CowRepository;
import com.bsuir.diploma.diploma.dao.FarmRepository;
import com.bsuir.diploma.diploma.domain.db.Farm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin/cattle")
@RequiredArgsConstructor
public class CattleController {
    @Autowired
    private CowRepository cowRepository;
    @Autowired
    private BullRepository bullRepository;
    @Autowired
    private FarmRepository farmRepository;

    @GetMapping
    public String getCattlePage(@RequestParam(name = "location", required = false) String location,  Model model) {
       if (location != null) {
           model.addAttribute("farm", farmRepository.findByLocation(location));
       }
        model.addAttribute("farms", farmRepository.findAll());
        model.addAttribute("cows", cowRepository.findAll());
        model.addAttribute("bull", bullRepository.findAll());
        return "/views/admin/cattle";
    }
}
