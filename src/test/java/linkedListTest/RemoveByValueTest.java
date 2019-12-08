package linkedListTest;

import linkedList.MyLinkedList;
import org.junit.Assert;
import org.junit.Test;

import java.util.ListIterator;

public class RemoveByValueTest {

    @Test
    public void removeByValueTest1(){
        MyLinkedList<Integer> list = new MyLinkedList<>();
        for (int i = 0; i < 4; i++) {
            list.add(i);
        }

        list.print();
        System.out.println();

        Object o = 0;
        list.remove(o);
        list.print();

        int [] arr = new int[]{1,2,3};
        int i = arr.length-1;
        ListIterator<Integer> iterator = list.listIterator(list.size());
        while (iterator.hasPrevious()){
            Assert.assertEquals(arr[i], (int) iterator.previous());
            i--;
        }

    }

    @Test
    public void removeByValueTest2(){
        MyLinkedList<Integer> list = new MyLinkedList<>();
        for (int i = 0; i < 4; i++) {
            list.add(i);
        }

        list.print();
        System.out.println();

        Object o = 2;
        list.remove(o);
        list.print();

        int [] arr = new int[]{0,1,3};
        int i = arr.length-1;
        ListIterator<Integer> iterator = list.listIterator(list.size());
        while (iterator.hasPrevious()){
            Assert.assertEquals(arr[i], (int) iterator.previous());
            i--;
        }

    }

    @Test
    public void removeByValueTest3(){
        MyLinkedList<Integer> list = new MyLinkedList<>();
        for (int i = 0; i < 4; i++) {
            list.add(i);
        }

        list.print();
        System.out.println();

        Object o = 3;
        list.remove(o);
        list.print();

        int [] arr = new int[]{0,1,2};
        int i = arr.length-1;
        ListIterator<Integer> iterator = list.listIterator(list.size());
        while (iterator.hasPrevious()){
            Assert.assertEquals(arr[i], (int) iterator.previous());
            i--;
        }

    }

}
