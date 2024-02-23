package org.gpt.interactionchatgpt.repository;

import org.gpt.interactionchatgpt.model.exchange;
import org.gpt.interactionchatgpt.model.user;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface exchangeRepository  extends JpaRepository <exchange, Long>{

    List<exchange> findByUserOrderByIdDesc(user user);


}

