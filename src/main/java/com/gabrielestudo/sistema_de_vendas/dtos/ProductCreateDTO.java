package com.gabrielestudo.sistema_de_vendas.dtos;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;

public record ProductCreateDTO(
        @NotBlank(message = "Campo obrigatório!") String name,
        @NotBlank(message = "Campo obrigatório!") String brand,
        BigDecimal price,
        String description,
        @NotBlank(message = "Campo obrigatório!") String category,
        Long supplier_id) {
}
