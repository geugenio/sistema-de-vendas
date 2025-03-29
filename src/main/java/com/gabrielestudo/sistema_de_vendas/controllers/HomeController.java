package com.gabrielestudo.sistema_de_vendas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("")
    public String home() {
        return "home";
    }

    @GetMapping("/fornecedor/")
    public String fornecedor() {
        return "redirect:/supplier/suppliers";
    }
}
