package arrayList;

import java.util.*;

// 5) Мне не нравится добавление и удаление элемент по индексу(add, addAll, removeByIndex).
// Не вижу вообще никакого смысла копировать 2 раза.
// 5.5) От метода removeByIndex вообще глаза заболели.
// 6) (Это 83 строка) Object[] collectionArray = c.toArray(new Object[c.size()]);
// Часть с new Object[c.size()] я вообще не понял нифига.
// 7) (86 строка) Советую присматриваться к советам ide, например:
// if (collectionArray.length > 0) return true;
// else return false;
// элегантно превращается в
// return collectionArray.length > 0;
// 8) Вообще, зачем тебе два метода: removeByIndex и remove?
// 9) Слишком много лишнего в тестах, +
// убери все принтлны и вообще все что не относится к assert`у.


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
        Object[] collectionArray = c.toArray(new Object[c.size()]);
        System.arraycopy(collectionArray,0,elementData,size,collectionArray.length);
        size += collectionArray.length;
        if (collectionArray.length > 0) return true;
        else return false;

    }

    public boolean addAll(int index, Collection<? extends E> c){
        checkIndexAdd(index);
        if (c == null){
            throw new NullPointerException();
        }
        increaseCapacityForCollection(size + c.size());
        Object[] collectionArray = c.toArray(new Object[c.size()]);
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
