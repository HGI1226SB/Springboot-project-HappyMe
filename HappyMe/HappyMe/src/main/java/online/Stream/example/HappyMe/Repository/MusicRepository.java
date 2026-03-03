package online.Stream.example.HappyMe.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yaml.snakeyaml.events.Event.ID;

import online.Stream.example.HappyMe.entity.Music;

public interface MusicRepository extends JpaRepository<Music, ID>{


    Music findBySongName(String songName);

    List<Music> findByGenre(String genre);

	
    



}
