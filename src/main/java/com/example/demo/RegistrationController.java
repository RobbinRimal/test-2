package com.example.demo;

import com.example.demo.services.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller

public class RegistrationController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;


    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("user",new UserInfo());
        return "registration";

    }

    @PostMapping("/register")
    public String processRegistration(@ModelAttribute RegistrationForm form) {

        userRepository.save(form.toUser(passwordEncoder));
        return "redirect:/login";
    }


}
