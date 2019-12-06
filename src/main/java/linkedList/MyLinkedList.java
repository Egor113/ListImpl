package linkedList;

import java.util.AbstractSequentialList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class MyLinkedList<E>
        extends AbstractSequentialList<E> {

    int size = 0;

    Node<E> first;

    Node<E> last;

    public MyLinkedList() {
        this.first = new Node<>(null,null,null);
        this.last = new Node<>(null,null,null);
    }

    public void addFirst(E e){
        linkFirst(e);
    }

    public boolean add(E e){
        linkLast(e);
        return true;
    }

    void linkLast(E e){
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null){
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    void linkFirst(E e){
        final Node<E> f = first;
        final Node<E> newNode = new Node<>(null, e, f);
        first = newNode;
        if (f == null){
            last = newNode;
        } else
            f.prev = newNode;
        size++;
    }

    public Iterator<E> iterator (){return new Itr();}

    private class Itr implements Iterator<E>{

        private Node<E> lastReturned;
        private Node<E> next;
        private int nextIndex;

        Itr() {
            this.lastReturned = first;
            this.next = first.next;
            this.nextIndex = 0;
        }

        @Override
        public boolean hasNext() {
            return nextIndex < size;
        }

        @Override
        public E next() {
            if (nextIndex >= size){
                throw new NoSuchElementException();
            }
            lastReturned = next;
            next = next.next;
            nextIndex ++;
            return lastReturned.item;
        }

        @Override
        public void remove() {

        }
    }

    public ListIterator<E> listIterator(boolean isFromFirst){
        return new ListItr(isFromFirst);
    }

    private class ListItr implements ListIterator<E>{

        private Node<E> directCurrent;
        private Node<E> reverseCurrent;
        private Node<E> next;
        private Node<E> last;
        private int nextIndex;
        private int lastIndex;

        ListItr(boolean isFromFirst) {
            Node<E> myFirst = MyLinkedList.this.first;
            Node<E> myLast = MyLinkedList.this.last;

            if (isFromFirst){
                this.directCurrent = myFirst;
                this.next = myFirst.next;
                this.nextIndex = 0;
            } else {
                this.reverseCurrent = myLast;
                this.last = myLast;
                this.lastIndex = size-1;
            }
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
            reverseCurrent = next;
            next = next.next;
            nextIndex ++;
            return reverseCurrent.item;
        }

        @Override
        public boolean hasPrevious() {
            return lastIndex >= 0;
        }

        @Override
        public E previous() {
            if (!hasPrevious()){
                throw new NoSuchElementException();
            }
            directCurrent = last;
            last = last.prev;
            lastIndex--;
            return directCurrent.item;
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
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
