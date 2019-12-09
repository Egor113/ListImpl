package linkedList;

import java.util.*;

public class MyLinkedList<E>
        extends AbstractSequentialList<E> {

    int size = 0;

    Node<E> first;

    Node<E> last;

    public MyLinkedList() {}

    private void linkFirst(E e) {

    }

    void linkLast(E e) {

    }

    void linkBefore(int index, E e){

    }

    E unlink(Node<E> x){
        return null;
    }

    public void addFirst(E e) {
        if (size == 0) {
            final Node<E> newElement = new Node<>(last, e, first);
            last = first = newElement;
            size ++;
        }
        else {
            final Node<E> firstElement = first;
            final Node<E> newElement = new Node<>(null, e, firstElement);
            first = newElement;
            firstElement.prev = newElement;
            size++;
        }
    }

    public void addLast(E e) {
        if (size == 0) {
            final Node<E> newElement = new Node<>(last, e, first);
            last = first = newElement;
            size ++;
        }
        else {
            final Node<E> lastElement = last;
            final Node<E> newElement = new Node<>(lastElement, e, null);
            last = newElement;
            lastElement.next = newElement;
            size++;
        }
    }

    public boolean add(E e) {
        addLast(e);
        return true;
    }

    public boolean remove(Object o){
        return false;
    }

    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    public void clear(){

    }

    public void add(int index, E element) {
        checkIndex(index);
        Node<E> current = node(index-1);
        if (index == 0){
            addFirst(element);
        } else if (index == size){
            addLast(element);
        } else {
            final Node<E> newNode = new Node<>(current, element, current.next);
            current.next.prev = newNode;
            current.next = newNode;
            size++;
        }
    }

    public E remove(int index){
        return null;
    }

    Node<E> node(int index) {
        Node<E> foundNode, current = last;
        foundNode = last;
        int currentIndex = size-1;

        while (current != null){
            if(currentIndex == index){
                foundNode = current;
            }
            current = current.prev;
            currentIndex--;
        }
        return foundNode;
    }

    public E get(int index){
        checkIndex(index);
        return node(index).item;
    }

    private void checkIndex(int index){
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException
                    ("Index: " + index + ", Size: " + size);
        }
    }


    @Override
    public ListIterator<E> listIterator(int index){
        return new ListItr(index);
    }

    private class ListItr implements ListIterator<E>{

        private Node<E> lastReturned;
        private Node<E> next;
        private int nextIndex;

        ListItr(int index) {
            next = (index == size) ? null : node(index);
            nextIndex = index;
        }

        @Override
        public boolean hasNext() {
            return nextIndex < size;
        }

        @Override
        public E next() {
            if (!hasNext()){
                throw new NoSuchElementException();
            }
            lastReturned = next;
            next = next.next;
            nextIndex ++;
            return lastReturned.item;
        }

        @Override
        public boolean hasPrevious() {
            return nextIndex > 0;
        }

        @Override
        public E previous() {
            if (!hasPrevious())
                throw new NoSuchElementException();

            lastReturned = next = (next == null) ? last : next.prev;
            nextIndex--;
            return lastReturned.item;
        }

        @Override
        public int nextIndex() {
            return 0;
        }

        @Override
        public int previousIndex() {
            return 0;
        }

        @Override
        public void remove() {

        }

        @Override
        public void set(E e) {

        }

        @Override
        public void add(E e) {

        }
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    @Override
    public int size() {
        return size;
    }

    public void print(){
        ListIterator<E> iterator = listIterator(size);
        while (iterator.hasPrevious()){
            System.out.print(iterator.previous() + " ");
        }
    }

}
