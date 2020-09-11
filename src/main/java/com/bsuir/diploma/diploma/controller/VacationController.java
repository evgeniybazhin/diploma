package com.bsuir.diploma.diploma.controller;

import com.bsuir.diploma.diploma.dao.EmployeeRepository;
import com.bsuir.diploma.diploma.dao.VacationRepository;
import com.bsuir.diploma.diploma.domain.db.Employee;
import com.bsuir.diploma.diploma.domain.db.Vacation;
import com.bsuir.diploma.diploma.domain.db.VacationStatus;
import com.bsuir.diploma.diploma.domain.db.dto.VacationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/vacation")
@RequiredArgsConstructor
public class VacationController {

    @Autowired
    private VacationRepository vacationRepository;

    @GetMapping
    public String getVacation(Model model) {
        List<Vacation> vacations = vacationRepository.findAllByVacationStatus(VacationStatus.REQUESTED);
        model.addAttribute("vacations", vacations);
        model.addAttribute("vac", new VacationDto());
        return "views/admin/vacation";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public String updateVacation(@ModelAttribute VacationDto vac) {
        System.out.println(vac);
        return "views/admin/vacation";
    }
}
