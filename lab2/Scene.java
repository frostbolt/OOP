package com.company;
public class Scene {
    int size;
    int maxSize;
    Object[] array;

    Scene(int sz) {
        this(sz,sz, null);
    }

    Scene(int sz, int maxSz) {
        this(sz, maxSz, null);
    }

    public boolean equals(Scene a) {
        if (size == a.size){
            for (int i=0; i<size;i++) {
                if (array[i]!=a.array[i]) {
                    return false;
                }
            }
        }   else {
            return false;
        }
        return true;
    }

    Scene(int sz, int maxSz, Object[] iniArray) {
        size = sz;
        maxSize = (maxSz<sz?sz:maxSz);
        array = new Object[maxSize];
        if (iniArray != null) {
            for (int i=0; i < size && i < iniArray.length; i++){
                array[i] = iniArray[i];
            }
        }
    }

    public Object el_a(int i) {
        return array[i];
    }

    public void resize(int delta) {
        if (delta > 0) enlarge(delta);
        else if (delta <0) shrink(-delta);
    }

    private void enlarge(int delta) {
        if((size+=delta) > maxSize) {
            maxSize = size;
            Object[] newArray = new Object[maxSize];
            for (int i=0; i < size - delta; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
    }

    private void shrink(int delta) {
        size = (delta > size ? 0 : size - delta);
    }

    void add(int e){
        resize(1);
        array[size-1]=e;
    }
}
