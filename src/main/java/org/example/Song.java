package org.example;

public class Song
{
    private String title;
    private String artist;
    private double length;

    // Constructor to initialize the Song object
    public Song(String title, String artist, double length) {
        this.title = title;
        this.artist = artist;
        this.length = length;
    }

    public String toString(){
        return String.format("songName: %s, artist: %s, length: %s", title, artist, length);
    }
}
