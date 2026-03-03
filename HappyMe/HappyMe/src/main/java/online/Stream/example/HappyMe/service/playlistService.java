package online.Stream.example.HappyMe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.Stream.example.HappyMe.Dao.playlistDao;
import online.Stream.example.HappyMe.ResponseEntity.ResponseStructure;
import online.Stream.example.HappyMe.entity.Music;
import online.Stream.example.HappyMe.entity.Movie;
import online.Stream.example.HappyMe.entity.Playlist;

@Service
public class PlaylistService {

    @Autowired
    private playlistDao playlistdao;

    // Register playlist
    public ResponseStructure registerplaylist(Playlist playlist) {
        Playlist savedPlaylist = playlistdao.registerPlaylist(playlist);
        if (savedPlaylist != null) {
            ResponseStructure structure = new ResponseStructure();
            structure.setData(savedPlaylist);
            structure.setMessage("Playlist registered successfully");
            structure.setStatusCode(201);
            return structure;
        } else {
            throw new RuntimeException("Playlist registration failed");
        }
    }

    // Add music to playlist
    public ResponseStructure addMusicToPlaylist(Playlist playlist, Long musicId) {
        Optional<Playlist> playlistOpt = playlistdao.addMusicToPlaylist(playlist, musicId);
        if (playlistOpt.isPresent()) {
            ResponseStructure structure = new ResponseStructure();
            structure.setData(playlistOpt.get());
            structure.setMessage("Music added to playlist successfully");
            structure.setStatusCode(202);
            return structure;
        } else {
            throw new RuntimeException("Failed to add music to playlist");
        }
    }

    // Add movie to playlist
    public ResponseStructure addMovieToPlaylist(Playlist playlist, Long movieId) {
        Optional<Playlist> playlistOpt = playlistdao.addMovieToPlaylist(playlist, movieId);
        if (playlistOpt.isPresent()) {
            ResponseStructure structure = new ResponseStructure();
            structure.setData(playlistOpt.get());
            structure.setMessage("Movie added to playlist successfully");
            structure.setStatusCode(202);
            return structure;
        } else {
            throw new RuntimeException("Failed to add movie to playlist");
        }
    }

    // Search playlist by name
    public ResponseStructure search(String playlistName) {
        List<Playlist> playlists = playlistdao.search(playlistName);
        if (playlists != null && !playlists.isEmpty()) {
            ResponseStructure structure = new ResponseStructure();
            structure.setData(playlists);
            structure.setMessage("Search successful");
            structure.setStatusCode(200);
            return structure;
        } else {
            throw new RuntimeException("No playlists found with name: " + playlistName);
        }
    }
}
