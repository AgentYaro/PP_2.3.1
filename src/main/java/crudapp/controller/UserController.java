package crudapp.controller;

import crudapp.model.User;
import crudapp.service.UserService;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    private UserService userServiceImpl;

    @Autowired
    public void setUserServiceImpl(UserService userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping(value = "/")
    public String main() {
        return "/main-page";
    }

    @GetMapping(value = "/list")
    public String list(Model model) {
        model.addAttribute("users", userServiceImpl.allUsers());
        return "/list-of-all";
    }

    @PatchMapping(value = "/edit")
    public String edit(Model model, @RequestParam long id) {
        model.addAttribute("type", 1);
        model.addAttribute("user", userServiceImpl.getById(id));
        return "/form";
    }

    @DeleteMapping(value = "/delete")
    public String delete(@RequestParam long id) {
        userServiceImpl.delete(id);
        return "redirect:/list";
    }

    @PostMapping(value = "/add")
    public String add(Model model) {
        model.addAttribute("type", 2);
        model.addAttribute("user", new User());
        return "/form";
    }

    @DeleteMapping(value = "/clear")
    public String clear() {
        userServiceImpl.cleanTable();
        return "redirect:/list";
    }

    @PutMapping(value = "/edit")
    public String editPost(@ModelAttribute("user") User user) {
        userServiceImpl.edit(user);
        return "redirect:/list";
    }

    @PutMapping(value = "/add")
    public String addPost(@ModelAttribute("user") User user) {
        userServiceImpl.add(user);
        return "redirect:/list";
    }
}