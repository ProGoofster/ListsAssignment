package com.jakeberryman.generics;

public class SNList<T> {
    private static class SLNode<T> {
        public T data;
        public SLNode<T> next;

        public SLNode(T s) {
            this(s, null);
        }

        public SLNode(T s, SLNode<T> n) {
            this.data = s;
            this.next = n;
        }
    }

    private SLNode<T> head;
    private int size;

    public SNList() {
        this.head = null;
        this.size = 0;
    }

    public void addy(T s){
        SLNode<T> newNode = new SLNode<>(s);

        if (head == null) {
            head = newNode;
        } else {
            SLNode<T> current = head;
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
            SLNode<T> current = head;
            for (int i = 0; i < pos - 1; i++) current = current.next;
            current.next = current.next.next;
        }
        size--;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        SLNode<T> current = head;

        while (current != null) {
            sb.append(current.data).append("\n"); // Append each song to the string
            current = current.next;
        }

        return sb.toString();
    }
}
