package arrayList;

import java.util.AbstractList;
import java.util.NoSuchElementException;
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

    private void ensureCapacity() {
        if (size >= maxSize) increaseCapacity();
    }

    public boolean add(E element){
        ensureCapacity();
        elementData[size++] = element;
        return true;
    }

    public void add(int index, E element){
        ensureCapacity();
        Object[] afterInsertBuffer = new Object[size-index];
        System.arraycopy(elementData,index,
                afterInsertBuffer,0,afterInsertBuffer.length);
        elementData[index] = element;
        System.arraycopy(afterInsertBuffer,0,elementData,
                index+1,afterInsertBuffer.length);
    }

    public E remove(int index){
        E element = get(index);
        Object[] afterRemoveBuffer = new Object[size-index-1];
        System.arraycopy(elementData,index+1,
                afterRemoveBuffer,0,afterRemoveBuffer.length);
        System.arraycopy(afterRemoveBuffer,0,elementData,index,afterRemoveBuffer.length);
        elementData[--size] = null;
        return element;
    }

    private void increaseCapacity(){
        maxSize = (maxSize * 3)/2 + 1;
        Object[] elementDataBuffer = new Object[maxSize];
        System.arraycopy(elementData,0,elementDataBuffer,0,size);
        elementData = elementDataBuffer;
    }

    public void printArray(){
        for (int i = 0; i < maxSize; i++) {
            System.out.print(elementData[i] + " ");
        }
    }

    @Override
    public E get(int index) {
        if (elementData[index] != null){
            return (E) elementData[index];
        }
        else throw new NoSuchElementException("No such index");
    }

    @Override
    public int size() {
        return size;
    }


    @Override
    public void replaceAll(UnaryOperator<E> operator) {

    }
}
