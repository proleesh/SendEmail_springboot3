package org.proleesh.sendemail.controller;

import lombok.RequiredArgsConstructor;
import org.proleesh.sendemail.valid.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    @GetMapping("/add")
    public String add() {
        return "/user/add";
    }

//    @PostMapping("/insert")
//    @ResponseBody
//    public User insert(@RequestBody User user) {
//
//    }
}
