package kazakov.spring.controller;


import kazakov.spring.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import kazakov.spring.model.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getListUser(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "/users";
    }

    @GetMapping("/new")
    public String addUserForm(Model model) {
        model.addAttribute("user", new User());
        return "users/new";
    }

    @PostMapping()
    public String addUser(@ModelAttribute("user") User user) {
        userService.createUser(user);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String editUserForm(@PathVariable("id") Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "users/edit";
    }

    @PostMapping("/save/{id}")
    public String editUser(@PathVariable("id") Long id, @ModelAttribute("user") User user) {
        userService.updateUser(id, user);
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUserForm(@PathVariable("id") Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "users/delete";
    }

    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id, @ModelAttribute("user") User user) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
