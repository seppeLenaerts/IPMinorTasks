package be.ucll.ip.tasks.controller;

import be.ucll.ip.tasks.dto.CreateUserDTO;
import be.ucll.ip.tasks.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class LoginController {
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String Login(){
        return "login";
    }

    @GetMapping("/signup")
    public String showRegistrationForm(Model model) {
        CreateUserDTO userDto = new CreateUserDTO();
        model.addAttribute("user", userDto);
        return "signup";
    }

    @PostMapping("/signup")
    public String postCreateUser(@ModelAttribute("user") @Valid CreateUserDTO user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "signup";
        }
        userService.createUser(user);
        return "redirect:/login";
    }
}
