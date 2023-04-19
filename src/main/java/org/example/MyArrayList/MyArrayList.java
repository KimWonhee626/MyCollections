package org.example.MyArrayList;

public class MyArrayList<T> {
    private Object[] list = new Object[3];
    private int size = 0;

    public int size(){
        return size;
    }

    public boolean add(T element){
        makeNewListIfNotEnough();
        list[size] = element;
        size++;
        return true;
    }

    private boolean isNotEnough(){
        return size >= list.length;
    }

    private void makeNewListIfNotEnough(){
        if(isNotEnough()) {
            Object[] newList = new Object[list.length * 2];

            for (int i = 0; i < list.length; i++) {
                newList[i] = list[i];
            }

            list = newList;
        }
    }

    public Object get(int index) {
        return list[index];
    }
}
