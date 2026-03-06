package com.Happyme.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Happyme.project.entity.Playlist;
import java.util.List;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {

    List<Playlist> findByUserId(Long userId);
}