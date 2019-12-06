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
        ListIterator<Integer> iterator = list.listIterator(false);
        while (iterator.hasPrevious()){
            System.out.println(iterator.previous());
        }
    }

}
