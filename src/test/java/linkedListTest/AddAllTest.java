package linkedListTest;

import linkedList.MyLinkedList;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class AddAllTest {

    @Test
    public void addAllTest1(){
        MyLinkedList<Integer> list = new MyLinkedList<>();
        for (int i = 0; i < 4; i++) {
            list.add(i);
        }

        list.print();
        System.out.println();

        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < 3; i++) {
            set.add(i * 100);
        }
        for (int i: set) {
            System.out.print(i + " ");
        }
        System.out.println();
        list.addAll(set);
        list.print();

        int [] arr = new int[]{0,1,2,3,100,200};
        int i = 5;
        ListIterator<Integer> iterator = list.listIterator(list.size());
        while (iterator.hasPrevious()){
            Assert.assertEquals(arr[i], (int) iterator.previous());
            i--;
        }
    }

    @Test
    public void addAllTest2(){
        MyLinkedList<Integer> list = new MyLinkedList<>();
        for (int i = 0; i < 4; i++) {
            list.add(i);
        }

        list.print();
        System.out.println();

        Set<Integer> set = new HashSet<>();

        list.addAll(set);
        list.print();

        int [] arr = new int[]{0,1,2,3};
        int i = 3;
        ListIterator<Integer> iterator = list.listIterator(list.size());
        while (iterator.hasPrevious()){
            Assert.assertEquals(arr[i], (int) iterator.previous());
            i--;
        }
    }

    @Test(expected = NullPointerException.class)
    public void addAllTest3(){
        MyLinkedList<Integer> list = new MyLinkedList<>();
        for (int i = 0; i < 4; i++) {
            list.add(i);
        }

        list.print();
        System.out.println();

        Set<Integer> set = null;

        list.addAll(set);
    }

}
