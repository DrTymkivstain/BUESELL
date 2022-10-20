package com.example.buysell.controller;

import com.example.buysell.models.User;
import com.example.buysell.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }


    @PostMapping("/registration")
    public String createUser(User user, Model model) {
        if (!userService.createUser(user)) {
            model.addAttribute("errorMessage"
                    ,"Користувач з email:" + user.getEmail() + "уже існує");
            return "registration";
        }
        userService.createUser(user);
        return "redirect:/login";
    }

    @GetMapping("/user/{user}")
    public String userInfo(@PathVariable User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("products", user.getProducts());
        return "user-info";
    }
}
