package linkedListTest;

import linkedList.MyLinkedList;
import org.junit.Assert;
import org.junit.Test;

import java.util.ListIterator;

public class AddLastWithIndexTest {

    @Test
    public void addWithIndexTest1(){
        MyLinkedList<Integer> list = new MyLinkedList<>();
        for (int i = 0; i < 4; i++) {
            list.add(i);
        }

        list.add(0,100);

        int [] arr = new int[]{100,0,1,2,3};
        int i = 4;
        ListIterator<Integer> iterator = list.listIterator(list.size());
        while (iterator.hasPrevious()){
            Assert.assertEquals(arr[i], (int) iterator.previous());
            i--;
        }

    }

    @Test
    public void addWithIndexTest2(){
        MyLinkedList<Integer> list = new MyLinkedList<>();
        for (int i = 0; i < 4; i++) {
            list.add(i);
        }

        list.add(list.size(),100);

        int [] arr = new int[]{0,1,2,3,100};
        int i = 4;
        ListIterator<Integer> iterator = list.listIterator(list.size());
        while (iterator.hasPrevious()){
            Assert.assertEquals(arr[i], (int) iterator.previous());
            i--;
        }

    }

    @Test
    public void addWithIndexTest3(){
        MyLinkedList<Integer> list = new MyLinkedList<>();
        for (int i = 0; i < 4; i++) {
            list.add(i);
        }

        list.add(2,100);

        int [] arr = new int[]{0,1,100,2,3};
        int i = 4;
        ListIterator<Integer> iterator = list.listIterator(list.size());
        while (iterator.hasPrevious()){
            Assert.assertEquals(arr[i], (int) iterator.previous());
            i--;
        }

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addWithIndexTest4(){
        MyLinkedList<Integer> list = new MyLinkedList<>();
        for (int i = 0; i < 3; i++) {
            list.add(i);
        }

        System.out.println();

        list.add(-1,100);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addWithIndexTest5(){
        MyLinkedList<Integer> list = new MyLinkedList<>();
        for (int i = 0; i < 4; i++) {
            list.add(i);
        }

        list.add(5,100);
    }

}
