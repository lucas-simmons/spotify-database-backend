package com.sp.top_songs.song;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SongRepository extends JpaRepository<Song, String> {
    void deleteByDate(String SongDate);

    Optional<Song> findByDate(String date);
}
