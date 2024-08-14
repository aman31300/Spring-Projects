package com.example.crudapp.repo;

import com.example.crudapp.model.products;
import com.example.crudapp.model.updatedProducts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class productRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void saveProducts(products products)
    {
        String query = "insert into products (pName,pDescription,pPrice) values(?,?,?)";
        jdbcTemplate.update(query, products.getpName(),products.getpDescription(),products.getpPrice());
    }
    public List<products> getAllProducts()
    {
        String query = "SELECT *FROM products";
        return jdbcTemplate.query(query,new BeanPropertyRowMapper<>(products.class));
    }
    public void deleteItem(String id)
    {
        System.out.println(id);
        String query  ="DELETE FROM products WHERE pid = ?";
        jdbcTemplate.update(query,id);
    }
    public void updateProducts(int id, updatedProducts products)
    {
        String query = "update products set pName = ?,pDescription = ?,pPrice = ? where pid = ?";
        jdbcTemplate.update(query, products.getName(),products.getDescription(),products.getPrice(),id);
    }
}
