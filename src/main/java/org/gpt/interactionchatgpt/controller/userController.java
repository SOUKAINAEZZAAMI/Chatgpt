package org.gpt.interactionchatgpt.controller;

import lombok.Data;
import org.gpt.interactionchatgpt.model.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.gpt.interactionchatgpt.service.userService;
@RestController
@Data
@CrossOrigin("*")
@RequestMapping("/gpt")

public class userController  {

    @Autowired
    private userService userservice;
    @GetMapping("/user")
    public user getUser(@RequestParam String nom)
    {

        user utilisateur =  userservice.getUtilisateur(nom);
        return utilisateur;

    }

    @PostMapping("/addUser")
    public user ajouterUtilisateur(@RequestBody user user) {
        return userservice.AjouterUtilisateur(user);
    }

}
