package linkedListTest;

import linkedList.MyLinkedList;
import org.junit.Assert;
import org.junit.Test;

import java.util.ListIterator;

public class RemoveByIndexTest {

    @Test
    public void removeByIndexTest1(){
        MyLinkedList<Integer> list = new MyLinkedList<>();
        for (int i = 0; i < 4; i++) {
            list.add(i);
        }

        list.print();
        System.out.println();

        list.remove(0);
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
    public void removeByIndexTest2(){
        MyLinkedList<Integer> list = new MyLinkedList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }

        list.print();
        System.out.println();

        list.remove(list.size());
        list.print();

        int [] arr = new int[]{0,1,2,3};
        int i = arr.length-1;
        ListIterator<Integer> iterator = list.listIterator(list.size());
        while (iterator.hasPrevious()){
            Assert.assertEquals(arr[i], (int) iterator.previous());
            i--;
        }

    }

    @Test
    public void removeByIndexTest3(){
        MyLinkedList<Integer> list = new MyLinkedList<>();
        for (int i = 0; i < 4; i++) {
            list.add(i);
        }

        list.print();
        System.out.println();

        list.remove(2);
        list.print();

        int [] arr = new int[]{0,1,3};
        int i = arr.length-1;
        ListIterator<Integer> iterator = list.listIterator(list.size());
        while (iterator.hasPrevious()){
            Assert.assertEquals(arr[i], (int) iterator.previous());
            i--;
        }

    }


}
