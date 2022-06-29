package crudapp.web.controller;

import crudapp.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
private static User user;
    static {user=new User("Ivanov","Ivan","Ivanovich");}
    @GetMapping(value = "/")
    public String main(Model model) {
                model.addAttribute("user",user);
        return "/main-page";
    }
    @GetMapping(value = "/list")
    public String list() {
        return "/list-of-all";
    }

}