package com.movies.Movies.controller;

import com.movies.Movies.model.UserModel;
import com.movies.Movies.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public ArrayList<UserModel> getAllUsers(){
        return  userService.getAllUsers();
    }

    @PostMapping("/save")
    public UserModel saveUser(@RequestBody UserModel user){
        return this.userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public Optional<UserModel> findUserById(@PathVariable("id") long id){
        return this.userService.findUserById(id);
    }

    @GetMapping("/role")
    public  ArrayList<UserModel> findByRole(@RequestParam("role") int role){
        return this.userService.findByRole(role);
    }
    @DeleteMapping(path = "/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        boolean ok = this.userService.deleteUser(id);
        if(ok){
            return "Se elimino user: " + id;
        }
        else{
            return "No se pudo eliminar el user: " + id;
        }
    }

}
