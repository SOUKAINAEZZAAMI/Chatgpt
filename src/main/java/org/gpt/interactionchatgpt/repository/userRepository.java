package org.gpt.interactionchatgpt.repository;

import org.gpt.interactionchatgpt.model.user;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository  extends JpaRepository<user, Long> {
    user findByUsername(String nom);
    //user findByUsernameAndPassword(String nom,String password);


}

