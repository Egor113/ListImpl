package linkedList;

import java.util.*;

public class MyLinkedList<E>
        extends AbstractSequentialList<E> {

    int size = 0;

    Node<E> first;

    Node<E> last;

    public MyLinkedList() {
    }

    private void linkFirst(E e) {
        final Node<E> f = first;
        final Node<E> newNode = new Node<>(null, e, f);
        first = newNode;
        if (f == null)
            last = newNode;
        else
            f.prev = newNode;
        size++;
    }

    void linkLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    void linkBefore(int index, E e){

        final Node<E> currentNode = node(index);
        final Node<E> newNode  = new Node<>(currentNode.prev, e, currentNode);
        if (newNode.prev != null){
            newNode.prev.next = newNode;
        }
        newNode.next.prev = newNode;
        size++;
    }

    private E unlinkLast(Node<E> l){
        final Node<E> prevNode = l.prev;
        prevNode.next = last;
        last = prevNode;
        size --;
        return l.item;
    }

    private E unlinkFirst(Node<E> f){
        final Node<E> nextNode = f.next;
        nextNode.prev = null;
        first = nextNode;
        size --;
        return f.item;
    }

    E unlink(Node<E> x){
        final E element = x.item;
        final Node<E> next = x.next;
        final Node<E> prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;
        modCount++;
        return element;
    }

    public void addFirst(E e) {
        linkFirst(e);
    }

    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    public boolean remove(Object o){
        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean addAll(Collection<? extends E> c) {
        return addAll(size, c);
    }

    public boolean addAll(int index, Collection<? extends E> c) {
        checkIndex(index);
        Object[] a = c.toArray();
        int numNew = a.length;
        if (numNew == 0)
            return false;

        Node<E> pred, succ;
        if (index == size) {
            succ = null;
            pred = last;
        } else {
            succ = node(index);
            pred = succ.prev;
        }

        for (Object o : a) {
            E e = (E) o;
            Node<E> newNode = new Node<>(pred, e, null);
            if (pred == null)
                first = newNode;
            else
                pred.next = newNode;
            pred = newNode;
        }

        if (succ == null) {
            last = pred;
        } else {
            pred.next = succ;
            succ.prev = pred;
        }

        size += numNew;
        return true;
    }

    public void add(int index, E element) {
        checkIndex(index);

        if (index == size)
            linkLast(element);
        else
            linkBefore(index, element);
    }

    public E remove(int index){
        checkIndex(index);
        return unlink(node(index));
    }

    Node<E> node(int index) {

        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    public E get(int index){
        checkIndex(index);
        return node(index).item;
    }

    public void checkIndex(int index){
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException
                    ("Index: " + index + ", Size: " + size);
        }
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
