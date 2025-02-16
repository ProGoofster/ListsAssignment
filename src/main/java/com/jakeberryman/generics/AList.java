package com.jakeberryman.generics;

import java.util.Arrays;

public class AList<T> {
    private T[] arr;
    private int size;

    public AList() {
        arr = (T[]) new Object[0];
        size = 0;
    }

    public void addy(T p){
        T[] newArr = (T[]) new Object[arr.length + 1];

        System.arraycopy(arr, 0, newArr, 0, arr.length);

        arr = newArr;

        arr[arr.length - 1] = p;
        size++;
    }

    public void removy(int pos){
        if (pos < 0 || pos >= size) {
            System.out.println("Position " + pos + " is out of bounds");
            return;
        }

        T[] newArr = (T[]) new Object[arr.length - 1];
        System.arraycopy(arr, 0, newArr, 0, pos);
        System.arraycopy(arr, pos + 1, newArr, pos, arr.length - pos - 1);

        arr = newArr;
        size--;
    }

    public String toString(){
        return Arrays.toString(arr);
    }
}
