package online.Stream.example.HappyMe.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import online.Stream.example.HappyMe.entity.Playlist;

public interface PlaylistRepository1 extends JpaRepository<Playlist, Long> {

    // Match the field name in your entity exactly (case-sensitive)
    List<Playlist> findByPlaylistName(String playlistName);

}
