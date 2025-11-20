package com.beautysalon.controller;

import com.beautysalon.entity.SalonService;
import com.beautysalon.service.SalonServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/services")
@RequiredArgsConstructor
public class ServiceController {
    private final SalonServiceService salonServiceService;

    @GetMapping
    public String getAllServices(Model model) {
        List<SalonService> services = salonServiceService.getAllServices();
        model.addAttribute("services", services);
        return "services/list";
    }

    @GetMapping("/{id}")
    public String getServiceById(@PathVariable Long id, Model model) {
        SalonService service = salonServiceService.getServiceById(id)
                .orElseThrow(() -> new RuntimeException("Service not found"));
        model.addAttribute("service", service);
        return "services/detail";
    }

    @GetMapping("/category/{category}")
    public String getServicesByCategory(@PathVariable String category, Model model) {
        List<SalonService> services = salonServiceService.getServicesByCategory(category);
        model.addAttribute("services", services);
        model.addAttribute("category", category);
        return "services/category";
    }
}