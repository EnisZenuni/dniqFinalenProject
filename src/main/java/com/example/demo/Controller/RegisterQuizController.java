package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/quiz")
public class RegisterQuizController {
    @GetMapping
    public String returnRegisterQuizView() {
        return "registerQuiz";
    }
}
