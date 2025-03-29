package com.gabrielestudo.sistema_de_vendas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gabrielestudo.sistema_de_vendas.dtos.ProductCreateDTO;
import com.gabrielestudo.sistema_de_vendas.model.Product;
import com.gabrielestudo.sistema_de_vendas.services.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @RequestMapping("/")
    public String listProducts(Model model) {
        model.addAttribute("products", productService.findAll());
        return "product/products";
    }

    @GetMapping("/form")
    public String showForm(ProductCreateDTO dto) {
        return "product/form";
    }

    @GetMapping("/list")
    public String showProducts(Model model) {
        model.addAttribute("products", productService.findAll());
        return "product/products";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute ProductCreateDTO data, Model model) {
        productService.save(data);
        return "redirect:/home";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id, Model model) {
        Product prod = productService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalido! Produto de ID: " + id));
        productService.delete(prod);
        return "redirect:/product/products";
    }

}