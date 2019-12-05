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

    private boolean ensureCapacity() {

        return size < maxSize ? true: false;
    }

    public boolean add(E element){
        if (ensureCapacity()){
            elementData[size++] = element;
        } else {
            maxSize = Math.round((maxSize * 3)/2) + 1;
            Object[] elementDataBuffer = new Object[maxSize];
            System.arraycopy(elementData,0,elementDataBuffer,0,size);
            elementData = elementDataBuffer;
            elementData[size++] = element;
        }
        return true;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }


    @Override
    public void replaceAll(UnaryOperator<E> operator) {

    }
}
