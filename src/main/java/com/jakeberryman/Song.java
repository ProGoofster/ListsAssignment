package com.jakeberryman;

public class Song
{
    private final String title;
    private final String artist;
    private final double length;

    // Constructor to initialize the Song object
    public Song(String title, String artist, double length) {
        this.title = title;
        this.artist = artist;
        this.length = length;
    }

    public String toString(){
        return String.format("{ songName: %s, artist: %s, length: %s }", title, artist, length);
    }
}
