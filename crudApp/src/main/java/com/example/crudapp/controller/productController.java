package com.example.crudapp.controller;

import com.example.crudapp.model.products;
import com.example.crudapp.model.updatedProducts;
import com.example.crudapp.service.productService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class productController {

    @Autowired
    private productService service;
    private int id;
    @RequestMapping("/show")
    public String show()
    {
        return "page";
    }
    @RequestMapping("/add")
    public String addProduct(Model model)
    {
        model.addAttribute("tittle","AddProduct");
        return "add";
    }
    @RequestMapping(path = "/process",method = RequestMethod.POST)
    public RedirectView process(@ModelAttribute products products)
    {
        service.addProduct(products);
        RedirectView view = new RedirectView();
        System.out.println(products);
        view.setUrl("getAll");
        return view;
    }
    @RequestMapping("/getAll")
    public String getAll(Model model)
    {
        List<products> products = service.getAll();
        System.out.println(products);
        model.addAttribute("products",products);
        return "products";
    }
    @RequestMapping("/delete/{id}")
    public RedirectView delete(@PathVariable String id,HttpServletRequest request)
    {
        RedirectView view = new RedirectView();
        service.deleteProduct(id);
        view.setUrl(request.getContextPath()+"/");
        return view;
    }
    @RequestMapping("/update/{id}")
    public String updateForm(@PathVariable int id)
    {
        this.id=id;
        System.out.println(id);
        return "updateForm";
    }
    @RequestMapping(path = "/processUpdate",method = RequestMethod.POST)
    public RedirectView update(@RequestParam("name")String name,@RequestParam("description") String des,@RequestParam("price") int price,Model m,HttpServletRequest request)
    {
        RedirectView view = new RedirectView();
        updatedProducts products = new updatedProducts(name,des,price);
        System.out.println(this.id);
        service.updateProduct(this.id,products);
        view.setUrl(request.getContextPath()+"/");
        this.id=0;
        return view;
    }
}
