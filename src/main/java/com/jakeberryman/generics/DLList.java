package com.jakeberryman.generics;

public class DLList<T> {
    private static class DLNode<T> {
        public T data;
        public DLNode<T> next;
        public DLNode<T> previous;

        public DLNode(T s) {
            this(s, null, null);
        }

        public DLNode(T s, DLNode<T> n, DLNode<T> p) {
            this.data = s;
            this.next = n;
            this.previous = p;
        }
    }

    private DLNode<T> head;
    private DLNode<T> tail;
    private int size;

    public DLList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addy(T s){
        DLNode<T> newNode = new DLNode<>(s);

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
            DLNode<T> current = tail;
            for (int i = size - 1 ; i > pos; i--) {
                current = current.previous;
            }
            current.previous.next = current.next;
            current.next.previous = current.previous;
        } else if (pos <= size/2) {
            DLNode<T> current = head;
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
        DLNode<T> current = head;

        while (current != null) {
            sb.append(current.data).append("\n"); // Append each song to the string
            current = current.next;
        }

        return sb.toString();
    }
}
