package com.ttt.hellospringboot.controller;

import com.ttt.hellospringboot.entity.User;
import com.ttt.hellospringboot.model.dto.UserDto;
import com.ttt.hellospringboot.service.impl.UserServiceImpl;
import com.ttt.hellospringboot.service.intf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/search")
    public  ResponseEntity<?> searchUser(@RequestParam(name = "keyword", required = false, defaultValue = "") String name){
        List<UserDto> users = userService.searchUser(name);
        return ResponseEntity.ok(users);
    }
    @PostMapping("/add-user")
    public User addUser(@RequestBody User user){
        return userService.save(user);
    }
    @PostMapping("/add-all-user")
    public List<User> addAllUser(@RequestBody List<User> users){
        return userService.saveAllUser(users);
    }
    @GetMapping("/users")
    public ResponseEntity<?> getListUser(){
        List<UserDto> users = userService.getListUser();
        return ResponseEntity.ok(users);
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id){
        UserDto result = userService.getUserById(id);
        return  ResponseEntity.ok(result);
    }
    @PutMapping("/users/{id}")
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }
    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable int id ){

        return userService.deleteUser(id);
    }
}
