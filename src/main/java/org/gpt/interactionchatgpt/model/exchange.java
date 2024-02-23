package org.gpt.interactionchatgpt.model;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class exchange {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int  id;
    private LocalDateTime Date;
    private String question;
    private String reponse;
    @JsonBackReference
    @ManyToOne
    private user user;
}
