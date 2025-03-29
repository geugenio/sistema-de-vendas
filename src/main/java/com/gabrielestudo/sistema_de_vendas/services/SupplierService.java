package com.gabrielestudo.sistema_de_vendas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gabrielestudo.sistema_de_vendas.dtos.SupplierCreateDTO;
import com.gabrielestudo.sistema_de_vendas.model.Supplier;
import com.gabrielestudo.sistema_de_vendas.repositories.SupplierRepository;

@Service
public class SupplierService {
    @Autowired
    SupplierRepository supplierRepository;

    public void save(SupplierCreateDTO data) {
        Supplier sup = new Supplier();
        sup.setCnpj(data.cnpj());
        sup.setName(data.name());
        sup.setPhone(data.phone());

        sup.setProducts(null);
        supplierRepository.save(sup);
    }

    public List<Supplier> findAll() {
        return supplierRepository.findAll();
    }
}
