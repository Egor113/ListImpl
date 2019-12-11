package linkedListTest;

import linkedList.MyLinkedList;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.ListIterator;
import java.util.Set;

public class RemoveAllTest {

    @Test
    public void removeAllTest1(){
        MyLinkedList<Integer> list = new MyLinkedList<>();
        for (int i = 0; i < 4; i++) {
            list.add(i);
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < 3; i++) {
            set.add(i);
        }

        list.removeAll(set);

        int [] arr = new int[]{0,3};
        int i = arr.length-1;
        ListIterator<Integer> iterator = list.listIterator(list.size());
        while (iterator.hasPrevious()){
            Assert.assertEquals(arr[i], (int) iterator.previous());
            i--;
        }
    }

    @Test
    public void removeAllTest2(){
        MyLinkedList<Integer> list = new MyLinkedList<>();
        for (int i = 0; i < 4; i++) {
            list.add(i);
        }

        Set<Integer> set = new HashSet<>();
        set.add(100);
        set.add(200);

        list.removeAll(set);

        int [] arr = new int[]{0,1,2,3};
        int i = arr.length-1;
        ListIterator<Integer> iterator = list.listIterator(list.size());
        while (iterator.hasPrevious()){
            Assert.assertEquals(arr[i], (int) iterator.previous());
            i--;
        }
    }

    @Test
    public void removeAllTest3(){
        MyLinkedList<Integer> list = new MyLinkedList<>();
        for (int i = 0; i < 4; i++) {
            list.add(i);
        }

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(300);

        list.myRemoveAll(set);

        int [] arr = new int[]{0,3};
        int i = arr.length-1;
        ListIterator<Integer> iterator = list.listIterator(list.size());
        while (iterator.hasPrevious()){
            System.out.println(iterator.previous());
            i--;
        }
    }

    @Test
    public void removeAllTest4(){
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(2);
        list.add(2);
        list.add(3);

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);

        list.myRemoveAll(set);
        Assert.assertEquals(0, list.size());
    }

    @Test(expected = NullPointerException.class)
    public void removeAllTest5(){
        MyLinkedList<Integer> list = new MyLinkedList<>();
        for (int i = 0; i < 4; i++) {
            list.add(i);
        }

        Set<Integer> set = null;

        list.removeAll(set);
    }
}
