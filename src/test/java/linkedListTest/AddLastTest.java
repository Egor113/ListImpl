package linkedListTest;

import linkedList.MyLinkedList;
import org.junit.Assert;
import org.junit.Test;

import java.util.ListIterator;

public class AddLastTest {

    @Test
    public void addLastTest1(){
        MyLinkedList<Integer> list = new MyLinkedList<>();
        for (int i = 0; i < 4; i++) {
            list.add(i);
        }
        list.print();

        int i = 3;
        ListIterator<Integer> iterator = list.listIterator(list.size());
        while (iterator.hasPrevious()){
            Assert.assertEquals(i, (int) iterator.previous());
            i--;
        }

    }

    @Test
    public void addLastTest2(){
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(1);
        list.add(null);
        list.add(3);

        list.print();

        Assert.assertEquals(1, (int) list.get(0));
        Assert.assertNull(list.get(1));
        Assert.assertEquals(3, (int) list.get(2));

    }


}
