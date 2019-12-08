package linkedListTest;

import linkedList.MyLinkedList;
import org.junit.Assert;
import org.junit.Test;

import java.util.ListIterator;

public class ClearTest {

    @Test
    public void removeByIndexTest1(){
        MyLinkedList<Integer> list = new MyLinkedList<>();
        for (int i = 0; i < 4; i++) {
            list.add(i);
        }

        list.print();
        System.out.println();

        list.clear();
        list.print();


    }

    @Test
    public void removeByIndexTest2(){
        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.print();
        System.out.println();

        list.clear();
        list.print();


    }

}
