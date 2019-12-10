package arrayList;

import java.util.*;

public class MyArrayList<E> extends AbstractList<E>{

    private static final int DEFAULT_CAPACITY = 10;

    private Object[] elementData;

    private int size;

    private int maxSize;

    public MyArrayList() {
        this.elementData = new Object[DEFAULT_CAPACITY];
        this.maxSize = DEFAULT_CAPACITY;
        this.size = 0;
    }

    public MyArrayList(int initialCapacity){
        if (initialCapacity >= 0){
            this.elementData = new Object[initialCapacity];
            this.maxSize = initialCapacity;
            this.size = 0;
        }
        else {
            throw new IllegalArgumentException("Illegal Capacity: "+
                    initialCapacity);
        }
    }

    private void checkCapacity() {
        if (size >= maxSize) increaseCapacity();
    }

    private void increaseCapacity(){
        maxSize = (maxSize * 3)/2 + 1;
        Object[] elementDataBuffer = new Object[maxSize];
        System.arraycopy(elementData,0,elementDataBuffer,0,size);
        elementData = elementDataBuffer;
    }

    private void increaseCapacityForCollection(int totalSize) {
        if (totalSize > maxSize) {
            maxSize = (totalSize * 3)/2 + 1;
            Object[] elementDataBuffer = new Object[maxSize];
            System.arraycopy(elementData,0,elementDataBuffer,0,size);
            elementData = elementDataBuffer;
        }
    }

    public boolean add(E element){
        checkCapacity();
        elementData[size++] = element;
        return true;
    }

    public void add(int index, E element){
        checkIndexAdd(index);
        checkCapacity();
        System.arraycopy(elementData, index, elementData,
                index + 1,size - index);
        elementData[index] = element;
    }

    public boolean addAll(Collection<? extends E> c){
        if (c == null){
            throw new NullPointerException();
        }
        increaseCapacityForCollection(size + c.size());
        Object[] collectionArray = c.toArray();
        System.arraycopy(collectionArray,0,elementData,size,collectionArray.length);
        size += collectionArray.length;
        return collectionArray.length > 0;

    }

    public boolean addAll(int index, Collection<? extends E> c){
        checkIndexAdd(index);
        if (c == null){
            throw new NullPointerException();
        }
        increaseCapacityForCollection(size + c.size());
        Object[] collectionArray = c.toArray();
        System.arraycopy(elementData, index, elementData,
                index + collectionArray.length, size-index);
        System.arraycopy(collectionArray,0,elementData,
                index,collectionArray.length);

        size += collectionArray.length;
        return true;
    }

    private void removeByIndex(int index){
        System.arraycopy(elementData,index + 1, elementData,
                index, size-index-1);
        elementData[--size] = null;
    }

    public E remove(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException
                    ("Index: " + index + ", Size: " + size);
        }
        E element = get(index);
        removeByIndex(index);
        return element;
    }

    public boolean remove(Object o){
        for (int i = 0; i < size; i++) {
            if (o.equals(elementData[i])){
                removeByIndex(i);
                return true;
            }
        }
        return false;
    }

    public void clear(){
        for (int i = 0; i < size; i++)
            elementData[i] = null;
        this.size = 0;
    }

    public Iterator<E> iterator(){
        return new Itr();
    }

    private class Itr implements Iterator<E> {

        int cursor;
        int lastRet = -1;

        Itr() {}

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public E next() {
            int i = cursor;
            if (i >= size){
                throw new NoSuchElementException();
            }
            Object[] elementDataCopy = MyArrayList.this.elementData;
            cursor = i + 1;
            return (E) elementDataCopy[lastRet = i];
        }

        @Override
        public void remove() {
            if (lastRet < 0){
                throw new IllegalStateException();
            }
            MyArrayList.this.remove(lastRet);
            cursor = lastRet;
            lastRet = -1;
        }
    }

    public boolean removeAll(Collection<?> c){
        int deleteCount = 0;
        Object[] collArr = c.toArray();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < collArr.length; j++) {
                if (elementData[i] != null && elementData[i].equals(collArr[j])){
                    elementData[i] = null;
                    deleteCount++;
                }
            }
        }
        int currentSize = size;
        for (int j = deleteCount; j > 0 ; j--) {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null){
                    System.arraycopy(elementData, i + 1,
                            elementData, i, size - i);
                    currentSize --;
                }
            }
        }
        size = currentSize;
        return deleteCount > 0;
    }

    public void printArray(){
        for (int i = 0; i < maxSize; i++) {
            System.out.print(elementData[i] + " ");
        }
        System.out.println();
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size || size == 0){
            throw new IndexOutOfBoundsException
                    ("Index: " + index + ", Size: " + size);
        }
        return (E) elementData[index];
    }

    private void checkIndexAdd(int index){
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException
                    ("Index: " + index + ", Size: " + size);
        }
    }

    @Override
    public int size() {
        return size;
    }

}
