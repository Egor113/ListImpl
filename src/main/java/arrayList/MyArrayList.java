package arrayList;

import java.util.AbstractList;
import java.util.function.UnaryOperator;

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

    public MyArrayList(int initialCapacity) throws Exception {
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

    private void ensureCapacity() {
        if (size >= maxSize) increaseCapacity();
    }

    public boolean add(E element){
        ensureCapacity();
        elementData[size++] = element;
        System.out.println("Size=" + size + " MaxSize=" + maxSize);
        return true;
    }

    public void add(int index, E element){
        ensureCapacity();
        Object[] afterInsertBuffer = new Object[size-index];
        System.arraycopy(elementData,size-index,afterInsertBuffer,0,size-index);
        elementData[index] = element;
        System.arraycopy(afterInsertBuffer,0,elementData,
                index+1,afterInsertBuffer.length);
    }

    private void increaseCapacity(){
        maxSize = Math.round((maxSize * 3)/2) + 1;
        Object[] elementDataBuffer = new Object[maxSize];
        System.arraycopy(elementData,0,elementDataBuffer,0,size);
        elementData = elementDataBuffer;
    }

    public void printArray(){
        for (Object o:elementData) {
            System.out.print(o + " ");
        }
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public int size() {
        return size;
    }


    @Override
    public void replaceAll(UnaryOperator<E> operator) {

    }
}
