package linkedListTest;

import linkedList.MyLinkedList;
import org.junit.Assert;
import org.junit.Test;

public class ClearTest {

    @Test
    public void clearTest1(){
        MyLinkedList<Integer> list = new MyLinkedList<>();
        for (int i = 0; i < 4; i++) {
            list.add(i);
        }

        list.clear();
        Assert.assertEquals(0, list.size());

    }

    @Test
    public void clearTest2(){
        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.clear();
        Assert.assertEquals(0, list.size());
    }

}
