package org.gpt.interactionchatgpt.controller;
import lombok.Data;
import org.gpt.interactionchatgpt.model.exchange;
import org.gpt.interactionchatgpt.service.exchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Data
@CrossOrigin("*")
@RequestMapping("/Keiken_test")

public class exchangeController {

    @Autowired
    private exchangeService exchangeGPTservice;


    @PostMapping("/utilisateurs/utilisateur/{userId}/propositions")
    public exchange addExchange(@PathVariable Long userId, @RequestParam String question) {
        exchange exchangeGPT = exchangeGPTservice.addExange(question,userId);
        return exchangeGPT;
    }

}
