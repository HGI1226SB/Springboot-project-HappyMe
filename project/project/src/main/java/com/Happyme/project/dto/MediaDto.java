package com.Happyme.project.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class MediaDto {

    private String title;
    private String type;
    private String genre;
    private String duration;
}