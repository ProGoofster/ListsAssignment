package com.jakeberryman;

import com.jakeberryman.generics.AList;
import com.jakeberryman.generics.DLList;
import com.jakeberryman.generics.SNList;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<DataStructure<Song>> lists = new ArrayList<>();
        lists.add(new SongAList());
        lists.add(new SongSNList());
        lists.add(new SongDLList());
        lists.add(new AList<>());
        lists.add(new SNList<>());
        lists.add(new DLList<>());

        for(DataStructure<Song> list : lists){
            list.addy(new Song("Buddy Holly", "Weezer", 2.65));
            list.addy(new Song("Wonderwall", "Oasis", 3.00));
        }

        for(DataStructure<Song> list : lists){
            System.out.println(list.getClass().getSimpleName() + "\n" + list);
        }
    }
}
