package com.gabrielestudo.sistema_de_vendas.dtos;

import java.math.BigDecimal;

public record ProductCreateDTO(String name, BigDecimal price, String description, String category, Long supplier_id) {

}
