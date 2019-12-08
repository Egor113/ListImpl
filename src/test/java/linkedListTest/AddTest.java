package linkedListTest;

import linkedList.MyLinkedList;
import org.junit.Test;

import java.util.ListIterator;

public class AddTest {

    @Test
    public void addTest1(){
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(1);
        list.add(2);
        ListIterator<Integer> iterator = list.listIterator(0);
        while (iterator.hasPrevious()){
            System.out.println(iterator.previous());
        }
    }

    @Test
    public void addTest2(){
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.addFirst(1);
        list.addFirst(2);
        System.out.println(list.get(0));
        System.out.println(list.get(1));

    }


}
