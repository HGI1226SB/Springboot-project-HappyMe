package com.Happyme.project.entity;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "media")
public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mediaId;
    private String title;
    private String type;
    private String genre;
    private String duration;
    private String filePath;
}