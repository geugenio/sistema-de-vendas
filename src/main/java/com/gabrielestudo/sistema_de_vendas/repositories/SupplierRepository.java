package com.gabrielestudo.sistema_de_vendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabrielestudo.sistema_de_vendas.model.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {

}
