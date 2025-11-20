package com.beautysalon.controller;

import com.beautysalon.entity.SalonService;
import com.beautysalon.entity.Master;
import com.beautysalon.service.SalonServiceService;
import com.beautysalon.service.MasterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final SalonServiceService salonServiceService;
    private final MasterService masterService;

    @GetMapping("/")
    public String home(Model model) {
        List<SalonService> services = salonServiceService.getAllServices();
        List<Master> masters = masterService.getAllMasters();

        model.addAttribute("services", services);
        model.addAttribute("masters", masters);
        return "home";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }
}