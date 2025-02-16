package com.jakeberryman;

import java.util.Arrays;

public class AList {
    private Song[] songs;
    private int size;

    public AList() {
        songs = new Song[0];
        size = 0;
    }

    public void addy(Song p){
        Song[] newSongs = new Song[songs.length + 1];

        System.arraycopy(songs, 0, newSongs, 0, songs.length);

        songs = newSongs;

        songs[songs.length - 1] = p;
        size++;
    }

    public void removy(int pos){
        if (pos < 0 || pos >= size) {
            System.out.println("Position " + pos + " is out of bounds");
            return;
        }

        Song[] newSongs = new Song[songs.length - 1];
        System.arraycopy(songs, 0, newSongs, 0, pos);
        System.arraycopy(songs, pos + 1, newSongs, pos, songs.length - pos - 1);

        songs = newSongs;
        size--;
    }

    public String toString(){
        return Arrays.toString(songs);
    }
}
