package org.gpt.interactionchatgpt.controller;
import lombok.Data;
import org.gpt.interactionchatgpt.model.exchange;
import org.gpt.interactionchatgpt.service.exchangeService;
import org.gpt.interactionchatgpt.service.gptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Data
@CrossOrigin("*")
@RequestMapping("/gpt")

public class exchangeController {

    @Autowired
    private exchangeService exchangeGPTservice;
    @Autowired
    private gptService gptService;

    @PostMapping("/users/user/{userId}/exchanging")
    public exchange addExchange(@PathVariable Long userId, @RequestParam("question") String question) {
       // exchange exchangeGPT =
           return     exchangeGPTservice.addExange(question,userId);
        //return exchangeGPT;
    }

    @GetMapping("/users/user/{userId}/exchanging")
    public List<exchange> getAllPropsGPTByUser(@PathVariable long userId) {
        return exchangeGPTservice.getAllPropsGPT(userId);
    }
}
