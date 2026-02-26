package com.Happyme.project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@Entity
@Table(name = "movies")
@AllArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(length = 1000)
    private String description;
    private String genre;
    private String language;
    private Integer duration; // in minutes
    private Integer releaseYear;
    private Double rating;
}
