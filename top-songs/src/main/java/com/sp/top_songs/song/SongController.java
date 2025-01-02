package com.sp.top_songs.song;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/song")
public class SongController {
    private final SongService songController;

    @Autowired
    public SongController(SongService songService) {
        this.songController = songService;
    }

    @GetMapping
    public List<Song> getSongs(
            @RequestParam(required=false) String artist,
            @RequestParam(required=false) String release_date,
            @RequestParam(required=false) String is_explicit,
            @RequestParam(required=false) Integer duration_ms,
            @RequestParam(required=false) String date) {

        if(artist!=null){
            return songController.getSongsByArtist(artist);
        }
        else if(release_date!=null){
            return songController.getSongsByReleaseDate(release_date);
        }
        else if(duration_ms!=null) {
            return songController.getSongsByDuration(duration_ms);
        }
        else if(date!=null){
            return songController.getSongsByYear(date);
        }
        else if (is_explicit!=null) {
            return songController.getSongsByExplicit(is_explicit);
        } else {
            return songController.getSongs();
        }

    }

    @PostMapping
    public ResponseEntity<Song> addDay(@RequestBody Song song) {
        Song createdSong = songController.addSong(song);
        return new ResponseEntity<>(createdSong, HttpStatus.CREATED);
    }



}
