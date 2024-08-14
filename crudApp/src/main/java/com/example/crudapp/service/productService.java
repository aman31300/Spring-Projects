package com.example.crudapp.service;

import com.example.crudapp.model.products;
import com.example.crudapp.model.updatedProducts;
import com.example.crudapp.repo.productRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class productService {

    @Autowired
    private productRepo productRepo;

    public void addProduct(products product)
    {
        productRepo.saveProducts(product);
    }
    public List<products> getAll()
    {
        return productRepo.getAllProducts();
    }
    public void deleteProduct(String id)
    {
        System.out.println(id);
        productRepo.deleteItem(id);
    }
    public void updateProduct(int id , updatedProducts products)
    {
        productRepo.updateProducts(id,products);
        System.out.println(id+" "+products);
    }
}
