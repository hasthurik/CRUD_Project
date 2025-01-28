package com.example.ecom_project.controller;


import com.example.ecom_project.model.Product;
import com.example.ecom_project.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {


    @Autowired
    private ProductService service;

    @GetMapping()
    public ResponseEntity<String> helloMessage() {
        return new ResponseEntity<>(service.printHelloMessege(), HttpStatus.OK);
    }

    @GetMapping("/products") //получение всех продуктов
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(service.getAllproducts(), HttpStatus.OK);
    }

    @GetMapping("/products/{id}")  //получение по id
    public ResponseEntity<Product> getProductById(@PathVariable int id) {

        Product product = service.getProductById(id);
        if (product != null)
            return new ResponseEntity<>(service.getProductById(id), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/products")     //добавление продукта
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        service.addProduct(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @DeleteMapping("/products/{id}") //удаление продукта по id
    public ResponseEntity<Product> deleteProduct(@PathVariable int id) {

        Product product = service.getProductById(id);
        if (product != null) {
            service.deleteProductById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/products/{id}")  //обновление продукта
    public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product product) {

        Product productUpdated = service.getProductById(id);
        if (productUpdated == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        try {
            Product prod = service.updateProduct(product, id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}