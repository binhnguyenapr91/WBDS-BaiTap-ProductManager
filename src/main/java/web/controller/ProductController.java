package web.controller;

import business.entities.Product;
import business.services.interfaces.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class ProductController {
    @Autowired
    private ProductServices productServices;

    @GetMapping("/listing")
    ModelAndView showAllProduct(){
        ModelAndView modelAndView = new ModelAndView("listing");
        modelAndView.addObject("products",productServices.getAllProduct());
        return modelAndView;
    }

    @GetMapping("/products/showAddForm")
    String showAddProductForm(Model model){
       model.addAttribute("product",new Product());
        return "addProduct";
    }

    @PostMapping("/products/add")
    RedirectView addProduct(Product product, RedirectAttributes redirectAttributes){
        product.setId((int) (Math.random()*1000));
        productServices.addProduct(product.getId(),product);
        redirectAttributes.addFlashAttribute("message","Add product successfull!");
        return new RedirectView("/listing");
    }

    @GetMapping("/products/{id}/delete")
    ModelAndView deleteProduct(@PathVariable (name="id") int id){
        productServices.deleteProduct(id);
        ModelAndView modelAndView = new ModelAndView("listing");
        modelAndView.addObject("products",productServices.getAllProduct());
        return modelAndView;
    }

    @GetMapping("/products/{id}/update")
    ModelAndView updateCustomer(@PathVariable (name = "id") int id){
        Product product = productServices.getProductById(id);
        ModelAndView modelAndView = new ModelAndView("update");
        modelAndView.addObject("product",product);
        return modelAndView;
    }

    @PostMapping("/products/update")
    RedirectView updateCustomer(Product product,RedirectAttributes redirectAttributes){
        productServices.updateProduct(product.getId(),product);
        redirectAttributes.addFlashAttribute("success","Update Product Successful");
        return new RedirectView("/listing");

    }

    @GetMapping("/products/{id}/view")
    String getProductById(@PathVariable(name="id") int id, Model model){
        model.addAttribute("product",productServices.getProductById(id));
        return "detail";
    }
}
