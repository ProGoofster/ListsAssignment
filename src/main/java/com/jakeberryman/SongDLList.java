package com.jakeberryman;

public class SongDLList implements DataStructure<Song> {
    private static class DLNode {
        public Song song;
        public DLNode next;
        public DLNode previous;

        public DLNode(Song s) {
            this(s, null, null);
        }

        public DLNode(Song s, DLNode n, DLNode p) {
            this.song = s;
            this.next = n;
            this.previous = p;
        }
    }

    private DLNode head;
    private DLNode tail;
    private int size;

    public SongDLList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addy(Song s){
        DLNode newNode = new DLNode(s);

        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
        }
        tail = newNode;
        size++;
    }

    public void removy(int pos){
        if (pos < 0 || pos >= size) {
            System.out.println("Position " + pos + " is out of bounds");
            return;
        }

        if (pos == 0) {
            head = head.next;
            if (head != null) head.previous = null;
            else tail = null;
        } else if (pos == size - 1) {
            tail = tail.previous;
            if (tail != null) tail.next = null;
            else head = null;
        } else if (pos > size/2) {
            DLNode current = tail;
            for (int i = size - 1 ; i > pos; i--) {
                current = current.previous;
            }
            current.previous.next = current.next;
            current.next.previous = current.previous;
        } else if (pos <= size/2) {
            DLNode current = head;
            for (int i = 0; i < pos; i++) {
                current = current.next;
            }
            current.previous.next = current.next;
            current.next.previous = current.previous;
        }
        size--;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        DLNode current = head;

        while (current != null) {
            sb.append(current.song).append("\n"); // Append each song to the string
            current = current.next;
        }

        return sb.toString();
    }
}
