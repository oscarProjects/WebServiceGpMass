package com.oscarvj.webservice.model;

import jakarta.persistence.*;

import lombok.*;


@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String authorName;
    private String contentDesc;
    private String dateCreate;

    // Constructors, getters, and setters (you can use your IDE to generate them)
}
