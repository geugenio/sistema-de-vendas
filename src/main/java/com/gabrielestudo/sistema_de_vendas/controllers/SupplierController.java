package com.gabrielestudo.sistema_de_vendas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gabrielestudo.sistema_de_vendas.dtos.SupplierCreateDTO;
import com.gabrielestudo.sistema_de_vendas.services.SupplierService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    SupplierService supplierService;

    @GetMapping("/list")
    public String listSuppliers(Model model) {
        model.addAttribute("suppliers", supplierService.findAll());
        return "supplier/suppliers";
    }

    @GetMapping("/form")
    public String showForm(Model model, SupplierCreateDTO data) {
        model.addAttribute("supplier", data);
        return "supplier/form";
    }

    @PostMapping("/add")
    public String addSupplier(@Valid @ModelAttribute SupplierCreateDTO data, Model model) {
        supplierService.save(data);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String removeSupplier(@PathVariable Long id) {
        if (!supplierService.existsById(id)) {
            throw new EntityNotFoundException("Supplier with id " + id + " not found");
        }
        supplierService.deleteById(id);
        return "redirect:/supplier/list";
    }

}
