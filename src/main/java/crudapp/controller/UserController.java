package crudapp.controller;

import crudapp.model.User;
import crudapp.service.UserService;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    private UserService userServiceImpl;
    private static final User user;

    static {
        user = new User("Ivanov", "Ivan", "Ivanovich");
    }

    @Autowired
    public void setUserServiceImpl(UserService userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping(value = "/")
    public String main(Model model) {
        model.addAttribute("user", user);
        return "/main-page";
    }

    @GetMapping(value = "/list")
    public String list(Model model) {
        model.addAttribute("users", userServiceImpl.allUsers());
        return "/list-of-all";
    }

    @GetMapping(value = "/edit")
    public String edit(Model model, @RequestParam long id) {
        model.addAttribute("type", 1);
        model.addAttribute("user", userServiceImpl.getById(id));
        return "/form";
    }

    @GetMapping(value = "/delete")
    public String delete(@RequestParam long id) {
        userServiceImpl.delete(id);
        return "redirect:/list";
    }

    @GetMapping(value = "/add")
    public String add(Model model) {
        model.addAttribute("type", 2);
        model.addAttribute("user", new User("enter surname","enter name","enter patronymic"));
        return "/form";
    }

    @GetMapping(value = "/clear")
    public String clear() {
        userServiceImpl.cleanTable();
        return "redirect:/list";
    }

    @PostMapping(value = "/edit")
    public String editPost(@ModelAttribute("user") User user) {
        userServiceImpl.edit(user);
        return "redirect:/list";
    }

    @PostMapping(value = "/add")
    public String addPost(@ModelAttribute("user") User user) {
        userServiceImpl.add(user);
        return "redirect:/list";
    }
}