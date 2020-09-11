package com.bsuir.diploma.diploma.controller;

import com.bsuir.diploma.diploma.dao.CowRepository;
import com.bsuir.diploma.diploma.domain.db.cattle.Cow;
import com.bsuir.diploma.diploma.service.CowService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user/cow")
@RequiredArgsConstructor
public class CowController {
    @Autowired
    private CowRepository cowRepository;
    @Autowired
    private CowService cowService;

    @GetMapping
    public String getOffspingPage(@RequestParam(value = "id", required = false) Long id, Model model) {
        if (id != null) {
            cowService.removeCow(id);
        }
        model.addAttribute("cowToUpdate", new Cow());
        return "/views/user/cow";
    }

    @PostMapping
    public String addOffspring() {
        cowService.addCow();
        return "redirect:/user/cow";
    }

    @PostMapping(value = "/update")
    public String updateCow(@ModelAttribute("cowToUpdate") Cow cow) {
        cowService.updateCow(cow);
        return "redirect:/user/cow";
    }
}
