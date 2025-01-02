package com.sp.top_songs.song;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name="topsongs")
public class Song {
    @Id
    @Column(name="song", unique=false)
   private String song;

   private int song_rank;
   private String date;
   private String artist;
   private int popularity;
   private int duration_ms;
   private String album_type;
   private int total_tracks;
   private String release_date;
   private boolean is_explicit;


    public Song(int song_rank, String date, String song, String artist, int popularity, int duration_ms, String album_type, int total_tracks, String release_date, boolean is_explicit) {
        this.song_rank = song_rank;
        this.date = date;
        this.song = song;
        this.artist = artist;
        this.popularity = popularity;
        this.duration_ms = duration_ms;
        this.album_type = album_type;
        this.total_tracks = total_tracks;
        this.release_date = release_date;
        this.is_explicit = is_explicit;
    }



    public void setDate(String date) {
        this.date = date;
    }

    public int getSongRank() {
        return song_rank;
    }

    public void setSongRank(int song_rank) {
        this.song_rank = song_rank;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public int getDuration_ms() {
        return duration_ms;
    }

    public void setDuration_ms(int duration_ms) {
        this.duration_ms = duration_ms;
    }

    public String getAlbum_type() {
        return album_type;
    }

    public void setAlbum_type(String album_type) {
        this.album_type = album_type;
    }

    public int getTotal_tracks() {
        return total_tracks;
    }

    public void setTotal_tracks(int total_tracks) {
        this.total_tracks = total_tracks;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public boolean isIs_explicit() {
        return is_explicit;
    }

    public void setIs_explicit(boolean is_explicit) {
        this.is_explicit = is_explicit;
    }

    public Song() {
    }

    public String getDate() {
        return date;
    }
}
