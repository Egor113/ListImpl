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
        if (initialCapacity > 0){
            this.elementData = new Object[initialCapacity];
            this.maxSize = initialCapacity;
            this.size = 0;
        }
        else {
            throw new IllegalArgumentException("Illegal Capacity: "+
                    initialCapacity);
        }

    }

    public Object[] getElementData() {
        return elementData;
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
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException
                    ("Index: " + index + ", Size: " + size);
        }
        checkCapacity();
        Object[] afterInsertBuffer = new Object[size-index];
        System.arraycopy(elementData,index,
                afterInsertBuffer,0,afterInsertBuffer.length);
        elementData[index] = element;
        System.arraycopy(afterInsertBuffer,0,elementData,
                index+1,afterInsertBuffer.length);
    }

    public boolean addAll(Collection<? extends E> c){
        if (c == null){
            throw new NullPointerException();
        }
        increaseCapacityForCollection(size + c.size());
        Object[] collectionArray = c.toArray(new Object[c.size()]);
        System.arraycopy(collectionArray,0,elementData,size,collectionArray.length);
        size += collectionArray.length;
        if (collectionArray.length > 0) return true;
        else return false;

    }

    public boolean addAll(int index, Collection<? extends E> c){
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException
                    ("Index: " + index + ", Size: " + size);
        }
        if (c == null){
            throw new NullPointerException();
        }
        increaseCapacityForCollection(size + c.size());
        Object[] collectionArray = c.toArray(new Object[c.size()]);
        Object[] afterInsertBuffer = new Object[size-index];
        System.arraycopy(elementData,index,
                afterInsertBuffer,0,afterInsertBuffer.length);
        System.arraycopy(collectionArray,0,elementData,
                index,collectionArray.length);
        System.arraycopy(afterInsertBuffer,0,elementData,
                index+collectionArray.length,afterInsertBuffer.length);
        size += collectionArray.length;
        return true;
    }

    private void removeByIndex(int index){
        Object[] afterRemoveBuffer = new Object[size-index-1];
        System.arraycopy(elementData,index+1,
                afterRemoveBuffer,0,afterRemoveBuffer.length);
        System.arraycopy(afterRemoveBuffer,0,elementData,index,afterRemoveBuffer.length);
        elementData[--size] = null;
    }

    public E remove(int index){
        if (index < 0 || index > size){
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

//    public boolean removeAll(Collection<?> c){
//        boolean isDeleted = false;
//        Object[] collArr = c.toArray(new Object[c.size()]);
//        for (int i = 0; i < size; i++) {
//            for (int j = 0; j < collArr.length; j++) {
//                if (elementData[i].equals(collArr[j])){
//                    elementData[i] = null;
//                    isDeleted = true;
//                }
//            }
//        }
//
//        return isDeleted;
//    }

    public void printArray(){
        for (int i = 0; i < maxSize; i++) {
            System.out.print(elementData[i] + " ");
        }
        System.out.println();
    }

    @Override
    public E get(int index) {
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException
                    ("Index: " + index + ", Size: " + size);
        }
        return (E) elementData[index];
    }

    @Override
    public int size() {
        return size;
    }

}
