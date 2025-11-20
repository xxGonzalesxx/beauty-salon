package com.beautysalon.controller;

import com.beautysalon.entity.Client;
import com.beautysalon.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final ClientService clientService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("client", new Client());
        return "auth/register";
    }

    @PostMapping("/register")
    public String registerClient(@ModelAttribute Client client) {
        clientService.registerClient(client);
        return "redirect:/auth/login?success";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "auth/login";
    }

    @PostMapping("/login")
    public String loginClient(@RequestParam String email,
                              @RequestParam String password,
                              Model model) {
        if (clientService.validateClient(email, password)) {
            return "redirect:/?loginSuccess";
        } else {
            model.addAttribute("error", "Invalid email or password");
            return "auth/login";
        }
    }
}