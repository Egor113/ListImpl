package linkedListTest;

import linkedList.MyLinkedList;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.ListIterator;
import java.util.Set;

public class AddAllWithIndexTest {

    @Test
    public void addAllWithIndexTest1(){
        MyLinkedList<Integer> list = new MyLinkedList<>();
        for (int i = 0; i < 4; i++) {
            list.add(i);
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < 4; i++) {
            set.add(i * 100);
        }

        list.addAll(0,set);

        int [] arr = new int[]{100,200,300,0,1,2,3};
        int i = 6;
        ListIterator<Integer> iterator = list.listIterator(list.size());
        while (iterator.hasPrevious()){
            Assert.assertEquals(arr[i], (int) iterator.previous());
            i--;
        }
    }

    @Test
    public void addAllWithIndexTest2(){
        MyLinkedList<Integer> list = new MyLinkedList<>();
        for (int i = 0; i < 4; i++) {
            list.add(i);
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < 4; i++) {
            set.add(i * 100);
        }

        list.addAll(2,set);

        int [] arr = new int[]{0,1,100,200,300,2,3};
        int i = 6;
        ListIterator<Integer> iterator = list.listIterator(list.size());
        while (iterator.hasPrevious()){
            Assert.assertEquals(arr[i], (int) iterator.previous());
            i--;
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAllWithIndexTest3(){
        MyLinkedList<Integer> list = new MyLinkedList<>();
        for (int i = 0; i < 4; i++) {
            list.add(i);
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < 3; i++) {
            set.add(i * 100);
        }

        list.addAll(-1,set);
    }

}
