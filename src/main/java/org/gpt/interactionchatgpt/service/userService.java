package org.gpt.interactionchatgpt.service;


import lombok.Data;
import org.gpt.interactionchatgpt.model.user;
import org.gpt.interactionchatgpt.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Data
public class userService {
    @Autowired
    private userRepository utilisateurRepository;


    public user AjouterUtilisateur(user utilisateur)
    {
        String nom=utilisateur.getUsername();
        user utilisateurExist = utilisateurRepository.findByUsername(nom);
        if (utilisateurExist == null) {
            return utilisateurRepository.save(utilisateur);
        } else {
            throw new RuntimeException("Un utilisateur avec ce nom existe déjà.");
        }

    }

    public user getUtilisateur(String nom)
    {
        user utilisateur = utilisateurRepository.findByUsername(nom);
        if (utilisateur != null) {
            return utilisateur;
        } else {
            return null;
        }

    }
}
