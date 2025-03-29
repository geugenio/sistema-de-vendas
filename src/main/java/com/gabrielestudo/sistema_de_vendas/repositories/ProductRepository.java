package com.gabrielestudo.sistema_de_vendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabrielestudo.sistema_de_vendas.model.Product;
import com.gabrielestudo.sistema_de_vendas.model.Supplier;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    public List<Product> findByCategory(String category);

    public List<Product> findBySupplier(Supplier supplier);
}
