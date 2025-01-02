package com.sp.top_songs.song;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SongService {
    private final SongRepository songRepository;
    private final DataSource dataSource;

    @Autowired
    public SongService(SongRepository songRepository, DataSource dataSource) {
        this.songRepository = songRepository;
        this.dataSource = dataSource;
    }

    public List<Song> getSongs() {

        return songRepository.findAll();
    }
    public List<Song> getSongsFromDate(String date) {
        return songRepository.findAll().stream()
                .filter(song -> song.equals(song.getDate()))
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Song> getSongsByArtist(String searchText) {
        return songRepository.findAll().stream()
                .filter(song ->song.getArtist().toLowerCase().contains(searchText.toLowerCase()))
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Song> getSongsByReleaseDate(String searchText) {
        return songRepository.findAll().stream()
                .filter(song -> song.getRelease_date().contains(searchText))
                .distinct()
                .collect(Collectors.toList());
    }
    public List<Song> getSongsByYear(String searchText) {
        return songRepository.findAll().stream()
                .filter(song ->song.getDate().contains(searchText))
                .distinct()
                .collect(Collectors.toList());
    }

    public Song addSong(Song song) {
        songRepository.save(song);
        return song;
    }

    public List<Song> getSongsByExplicit(String searchText) {
        return songRepository.findAll().stream()
                .filter(song ->song.isIs_explicit())
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Song> getSongsByDuration(int searchText) {
        return songRepository.findAll().stream()
                .filter(song ->song.getDuration_ms()<searchText)
                .distinct()
                .collect(Collectors.toList());
    }
}
