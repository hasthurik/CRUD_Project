package com.example.ecom_project.service;

import com.example.ecom_project.model.Product;
import com.example.ecom_project.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo repo;

    public List<Product> getAllproducts() {
        return repo.findAll();
    }

    public Product getProductById(int id) {
        return repo.findById(id).orElse(null);
    }

    public void addProduct(Product product) {
        repo.save(product);
    }

    public void deleteProductById(int id) {
        repo.deleteById(id);
    }

    public Product updateProduct(Product product, int id) {
        repo.deleteById(id);
        return repo.save(product);
    }

    public String printHelloMessege() {
        return "Hello bro";
    }
}
