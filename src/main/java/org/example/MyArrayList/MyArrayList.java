package org.example.MyArrayList;

import java.util.stream.IntStream;

public class MyArrayList<T> {
    public boolean debug = false;
    private Object[] list;

    private int size = 0;

    public MyArrayList() {
        this(10);
    }

    public MyArrayList(int listLength) {
        list = new Object[listLength];
    }

    public int size(){
        return size;
    }

    public boolean add(T element){
        expandIfFull();
        list[size] = element;
        size++;

        return true;
    }

    public boolean add(int index, T element){
        expandIfFull();
        makeEmptyIndex(index);
        list[index] = element;
        size++;

        return true;
    }

    private boolean isFull(){
        return size == list.length;
    }

    private void expandIfFull(){
        if(isFull()) {
            Object[] newList = new Object[list.length * 2];

            for (int i = 0; i < list.length; i++) {
                newList[i] = list[i];
            }

            list = newList;
        }
    }

    private void makeEmptyIndex(int index){
        for(int i = size - 1; i >= index; i--){
            list[i + 1] = list[i];
        }
    }

    public T get(int index) {
        return (T) list[index];
    }

    public boolean set(int index, T element){
        list[index] = element;
        return true;
    }

    public T remove(int index) {
        T removedData = get(index);
        for(int i = index + 1; i < size; i++){
            list[i - 1] = list[i];
        }
        size--;

        return removedData;
    }

    public int indexOf(T element) {
        return IntStream.range(0, size)
                .filter(index -> element.equals(list[index]))
                .findFirst()
                .orElse(-1);
    }


    public boolean contains(T element) {
        return indexOf(element) != -1;
    }

    public void clear() {
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
