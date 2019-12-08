package linkedListTest;

import linkedList.MyLinkedList;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

public class AddAllWithIndexTest {

    @Test
    public void addWithIndexTest1(){
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(1);
        list.add(2);

        list.print();

        System.out.println();

        list.addAll(new ArrayList<>(Arrays.asList(10,20,30)));

        list.print();

    }

}
