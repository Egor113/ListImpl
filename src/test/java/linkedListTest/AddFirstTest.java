package linkedListTest;

import linkedList.MyLinkedList;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.ListIterator;

public class AddFirstTest {

    @Test
    public void addFirstTest1(){
        MyLinkedList<Integer> list = new MyLinkedList<>();

        for (int i = 0; i < 4; i++) {
            list.addFirst(i);
        }
        list.print();

        int i = 0;
        ListIterator<Integer> iterator = list.listIterator(list.size());
        while (iterator.hasPrevious()){
            Assert.assertEquals(i, (int) iterator.previous());
            i++;
        }

    }

    @Test
    public void addFirstTest2(){

        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.addFirst(1);
        list.addFirst(null);
        list.addFirst(3);

        list.print();

        Assert.assertEquals(3, (int) list.get(0));
        Assert.assertNull(list.get(1));
        Assert.assertEquals(1, (int) list.get(2));

    }

}
