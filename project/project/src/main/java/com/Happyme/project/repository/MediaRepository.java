package com.Happyme.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Happyme.project.entity.Media;
import java.util.List;

public interface MediaRepository extends JpaRepository<Media, Long> {

    List<Media> findByType(String type);
    List<Media> findByTitleContaining(String title);
}