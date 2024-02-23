package org.gpt.interactionchatgpt.service;

import org.gpt.interactionchatgpt.model.exchange;
import org.gpt.interactionchatgpt.model.user;
import org.gpt.interactionchatgpt.repository.userRepository;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.gpt.interactionchatgpt.repository.exchangeRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.json.JSONObject;

@Service
public class exchangeService {
    @Autowired
    private gptService gptService;
@Autowired
private exchangeRepository exchangeRepository;
@Autowired
private userRepository userRepository;
    public exchange addExange(String question,Long idUser) {

        Optional<user> optionalUser = userRepository.findById(idUser);

        if (optionalUser.isPresent()) {
            exchange exchange = new exchange();
            user utilisateur = optionalUser.get();
            exchange.setUser(utilisateur);
            exchange.setDate(LocalDateTime.now());
            exchange.setQuestion(question);
            String reponse = gptService.askChatGpt(question);
            // String reponseGPT=ReponseGPT(reponse);

            exchange.setReponse(reponse);
            return exchangeRepository.save(exchange);
        } else {
            throw new NoSuchElementException("Utilisateur non trouvé avec l'ID : " + idUser);
        }


    }
    public List<exchange> getAllPropsGPT(long idUtilisateur) {
        Optional<user> optionalUser = userRepository.findById(idUtilisateur);

        if (optionalUser.isPresent()) {
            user user = optionalUser.get();
            return exchangeRepository.findByUserOrderByIdDesc(user);
        } else {
            throw new NoSuchElementException("Utilisateur non trouvé avec l'ID : " + idUtilisateur);
        }
    }

}
