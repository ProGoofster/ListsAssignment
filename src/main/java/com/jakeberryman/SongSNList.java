package com.jakeberryman;

public class SongSNList implements DataStructure<Song> {
    private static class SLNode {
        public Song song;
        public SLNode next;

        public SLNode(Song s) {
            this(s, null);
        }

        public SLNode(Song s, SLNode n) {
            this.song = s;
            this.next = n;
        }
    }

    private SLNode head;
    private int size;

    public SongSNList() {
        this.head = null;
        this.size = 0;
    }

    public void addy(Song s){
        SLNode newNode = new SLNode(s);

        if (head == null) {
            head = newNode;
        } else {
            SLNode current = head;
            while (current.next != null) current = current.next;
            current.next = newNode;
        }
        size++;
    }

    public void removy(int pos){
        if (pos < 0 || pos >= size) {
            System.out.println("Position " + pos + " is out of bounds");
            return;
        }

        if (pos == 0) {
            head = head.next;
        } else {
            SLNode current = head;
            for (int i = 0; i < pos - 1; i++) current = current.next;
            current.next = current.next.next;
        }
        size--;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        SLNode current = head;

        while (current != null) {
            sb.append(current.song).append("\n"); // Append each song to the string
            current = current.next;
        }

        return sb.toString();
    }
}
