package com.gabrielestudo.sistema_de_vendas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielestudo.sistema_de_vendas.dtos.ProductCreateDTO;
import com.gabrielestudo.sistema_de_vendas.model.Product;
import com.gabrielestudo.sistema_de_vendas.model.Supplier;
import com.gabrielestudo.sistema_de_vendas.repositories.ProductRepository;
import com.gabrielestudo.sistema_de_vendas.repositories.SupplierRepository;

@Service
public class ProductService {
    @Autowired
    SupplierRepository supplierRepository;
    @Autowired
    ProductRepository productRepository;

    public void save(ProductCreateDTO data) {

        Product prod = new Product();
        prod.setAmount(0);
        prod.setDescription(data.description());
        prod.setName(data.name());
        prod.setPrice(data.price());
        prod.setCategory(data.category());

        Supplier sup = supplierRepository.findById(data.supplier_id())
                .orElseThrow(() -> new IllegalArgumentException("Erro! Fornecedor não encontrado"));
        prod.setSupplier(sup);

        productRepository.save(prod);
    }

    public void delete(Product product) {
        productRepository.delete(product);
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public List<Product> findBySupplier(Supplier supplier) {
        return productRepository.findBySupplier(supplier);
    }

    public List<Product> findByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

}
