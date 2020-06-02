package web.controller;

import business.entities.Login;
import business.entities.User;
import business.services.interfaces.ProductServices;
import business.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.jws.WebParam;

@Controller
public class UserController {
    @Autowired
    public UserService userService;
    public ProductServices productServices;

    @GetMapping("/")
    String showLoginForm(Model model){
        model.addAttribute("login",new Login());
        return "loginForm";
    }

    @PostMapping("/login")
    ModelAndView login(Login login){
        User user = userService.checkLogin(login);
        String url = "";
        if(user != null){
            url="/welcome";
        }else url="/";
        ModelAndView modelAndView = new ModelAndView(url);
        modelAndView.addObject("user",user);
        return modelAndView;
    }
}
