package com.maria.vtbMarket.controller;


import com.maria.vtbMarket.entity.Product;
import com.maria.vtbMarket.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MyController {

    private ProductService service;

    @Autowired
    public MyController(ProductService service){
        this.service = service;
    }

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public String getAllProductsWithView(@RequestParam("view") @Nullable String view, Model model) {
        model.addAttribute("productList", service.getAllProducts());
        return view == null ? "list" : view;
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public String getProduct(@PathVariable("id") int id, Model model) {
        model.addAttribute("product", service.get(id));
        return "product";
    }

    @RequestMapping(value = "/product/new", method = RequestMethod.GET)
    public String printForm() {
        return "add-product";
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute Product product, Model model) {
        service.add(product);
        return getAllProductsWithView(null, model);
    }

}
