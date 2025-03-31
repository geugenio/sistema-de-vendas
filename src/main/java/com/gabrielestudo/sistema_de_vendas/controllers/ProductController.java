package com.gabrielestudo.sistema_de_vendas.controllers;

import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gabrielestudo.sistema_de_vendas.dtos.ProductCreateDTO;
import com.gabrielestudo.sistema_de_vendas.model.Product;
import com.gabrielestudo.sistema_de_vendas.services.ProductService;
import com.gabrielestudo.sistema_de_vendas.services.SupplierService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private SupplierService supplierService;

    @RequestMapping("/")
    public String listProducts(Model model) {
        model.addAttribute("products", productService.findAll());
        return "product/products";
    }

    @GetMapping("/form")
    public String showForm(Model model) {
        ProductCreateDTO productCreateDTO = new ProductCreateDTO("", "", BigDecimal.valueOf(0), "", "", null);
        model.addAttribute("suppliers", supplierService.findAll());
        model.addAttribute("product", productCreateDTO);
        return "product/form";
    }

    @GetMapping("/list")
    public String showProducts(Model model) {
        model.addAttribute("products", productService.findAll());
        return "product/products";
    }

    @PostMapping("/add")
    public String addProduct(@Valid @ModelAttribute ProductCreateDTO data, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "product/form";
        }
        productService.save(data);
        return "redirect:/product/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id, Model model) {
        Product prod = productService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalido! Produto de ID: " + id));
        productService.delete(prod);
        return "redirect:/product/products";
    }

}