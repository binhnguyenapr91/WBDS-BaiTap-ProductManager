package web.controller;

import business.services.impl.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {
    @Autowired
    private ProductServices productServices;

    @GetMapping("/")
    ModelAndView showAllProduct(){
        ModelAndView modelAndView = new ModelAndView("listing");
        modelAndView.addObject("products",productServices.getAllProduct());
        return modelAndView;
    }

    @GetMapping("/products/add")
    ModelAndView addProduct(){
        ModelAndView modelAndView = new ModelAndView("addProduct");
        return modelAndView;
    }

    @GetMapping("/products/{id}/view")
    String getProductById(@PathVariable(name="id") int id, Model model){
        model.addAttribute("product",productServices.getProductById(id));
        return "detail";
    }
}
