package com.infobyte.library.controller;

import com.infobyte.library.module.User;
import com.infobyte.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/save")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }
    @GetMapping("/get")
    public User getById(@RequestParam Long id){
        return userService.getById(id);
    }

}
