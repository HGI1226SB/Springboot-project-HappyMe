package com.Happyme.project.entity;
import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "playlist")
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long listId;
    private Long userId;
    private Long mediaId;
}