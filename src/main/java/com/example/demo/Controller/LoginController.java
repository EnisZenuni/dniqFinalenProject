package com.example.demo.Controller;

import com.example.demo.Model.Exceptions.InvalidArgumentsException;
import com.example.demo.Model.Exceptions.InvalidUserCredentialsException;
import com.example.demo.Model.User;
import com.example.demo.Service.AuthServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping({" ","/","/login"})
public class LoginController {

    private final AuthServiceImpl authService;

    public LoginController(AuthServiceImpl authService) {
        this.authService = authService;
    }
    @GetMapping()
    public String LogInView() {
        return "login";
    }

    @PostMapping("/login")
    public String login(HttpServletRequest request, Model model) {
        User user = null;
        try{
            user = this.authService.login(request.getParameter("username"), request.getParameter("password"));
            request.getSession().setAttribute("user", user);
            return "redirect:/home";
        }
        catch (InvalidUserCredentialsException exception) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", exception.getMessage());
            return "login";
        }
    }

    @GetMapping("/register")
    public String registerView() {
        return "register";
    }
    @PostMapping("/register")
    public String register(HttpServletRequest request, Model model,
                           @RequestParam String username,
                           @RequestParam String password,
                           @RequestParam String email,
                           @RequestParam String number) {
        try {
            this.authService.register(username,password,email,number);
            return "redirect:/quiz";
        } catch (InvalidArgumentsException exception) {
            return "redirect:/register?error=" + exception.getMessage();
        }
    }
}
