package com.beautysalon.controller;

import com.beautysalon.entity.Master;
import com.beautysalon.service.MasterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/masters")
@RequiredArgsConstructor
public class MasterController {
    private final MasterService masterService;

    @GetMapping
    public String getAllMasters(Model model) {
        List<Master> masters = masterService.getAllMasters();
        model.addAttribute("masters", masters);
        return "masters/list";
    }

    @GetMapping("/{id}")
    public String getMasterById(@PathVariable Long id, Model model) {
        Master master = masterService.getMasterById(id)
                .orElseThrow(() -> new RuntimeException("Master not found"));
        model.addAttribute("master", master);
        return "masters/detail";
    }

    @GetMapping("/service/{serviceId}")
    public String getMastersByService(@PathVariable Long serviceId, Model model) {
        List<Master> masters = masterService.getMastersByService(serviceId);
        model.addAttribute("masters", masters);
        return "masters/list";
    }
}