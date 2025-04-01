package com.gabrielestudo.sistema_de_vendas.dtos;

import jakarta.validation.constraints.NotBlank;

public record SupplierCreateDTO(
        @NotBlank(message = "Campo obrigatório!") String name,
        @NotBlank(message = "Campo obrigatório!") String cnpj,
        @NotBlank(message = "Campo obrigatório!") String phone) {

}
