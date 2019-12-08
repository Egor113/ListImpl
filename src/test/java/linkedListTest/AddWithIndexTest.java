package linkedListTest;

import linkedList.MyLinkedList;
import org.junit.Test;

import java.util.ListIterator;

public class AddWithIndexTest {

    @Test
    public void addWithIndexTest1(){
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(1);
        list.add(2);

        ListIterator<Integer> iterator = list.listIterator(list.size());
        while (iterator.hasPrevious()){
            System.out.print(iterator.previous() + " ");
        }

        System.out.println();
        list.add(0,100);

        ListIterator<Integer> iterator2 = list.listIterator(list.size());
        while (iterator2.hasPrevious()){
            System.out.print(iterator2.previous() + " ");
        }

    }

}
