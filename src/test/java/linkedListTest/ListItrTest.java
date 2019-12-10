package linkedListTest;

import linkedList.MyLinkedList;
import org.junit.Assert;
import org.junit.Test;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class ListItrTest {

    @Test
    public void listItrTest1(){
        MyLinkedList<Integer> list = new MyLinkedList<>();
        for (int i = 1; i < 4; i++) {
            list.add(i);
        }

        int [] arr = new int[]{1,2,3};
        int i = arr.length-1;
        ListIterator<Integer> iterator = list.listIterator(list.size());
        while (iterator.hasPrevious()){
            Assert.assertEquals(arr[i], (int) iterator.previous());
            i--;
        }
    }

    @Test
    public void listItrTest2(){
        MyLinkedList<Integer> list = new MyLinkedList<>();
        for (int i = 1; i < 4; i++) {
            list.add(i);
        }

        int [] arr = new int[]{1,2,3};
        int i = 0;
        ListIterator<Integer> iterator = list.listIterator(list.size());
        while (iterator.hasNext()){
            Assert.assertEquals(arr[i], (int) iterator.next());
            i++;
        }
    }

    @Test
    public void ListItrTest3(){
        MyLinkedList<Integer> list = new MyLinkedList<>();
        for (int i = 1; i < 4; i++) {
            list.add(i);
        }

        ListIterator<Integer> iterator = list.listIterator(0);
        while (iterator.hasNext()){
            iterator.next();
            iterator.remove();
        }

        Assert.assertEquals(0, list.size());
    }

    @Test(expected = IllegalStateException.class)
    public void ListItrTest4(){
        MyLinkedList<Integer> list = new MyLinkedList<>();
        for (int i = 1; i < 4; i++) {
            list.add(i);
        }

        ListIterator<Integer> iterator = list.listIterator(0);
        while (iterator.hasNext()){
            iterator.remove();
            iterator.next();
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void ListItrTest5(){
        MyLinkedList<Integer> list = new MyLinkedList<>();
        for (int i = 1; i < 4; i++) {
            list.add(i);
        }

        ListIterator<Integer> iterator = list.listIterator(0);
        iterator.previous();
    }


}
