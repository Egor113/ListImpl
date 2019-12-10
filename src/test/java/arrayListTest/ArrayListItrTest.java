package arrayListTest;

import arrayList.MyArrayList;
import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayListItrTest {

    @Test
    public void ArrayListIterator1(){
        MyArrayList<String> list = new MyArrayList<>(4);
        for (int i = 1; i <= 4; i++) {
            list.add(Integer.toString(i));
        }

        Iterator<String> iterator = list.iterator();
        int i = 0;
        while (iterator.hasNext()){
            Assert.assertEquals(list.get(i),iterator.next());
            i++;
        }
    }

    @Test
    public void ArrayListIterator2(){
        MyArrayList<String> list = new MyArrayList<>(4);
        for (int i = 1; i <= 4; i++) {
            list.add(Integer.toString(i));
        }

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            iterator.next();
            iterator.remove();
        }

        Assert.assertEquals(0, list.size());
    }

    @Test(expected = NoSuchElementException.class)
    public void ArrayListIterator3(){
        MyArrayList<String> list = new MyArrayList<>(4);
        for (int i = 1; i <= 4; i++) {
            list.add(Integer.toString(i));
        }

        Iterator<String> iterator = list.iterator();
        while (true){
           iterator.next();
        }
    }

    @Test(expected = IllegalStateException.class)
    public void ArrayListIterator4(){
        MyArrayList<String> list = new MyArrayList<>(4);
        for (int i = 1; i <= 4; i++) {
            list.add(Integer.toString(i));
        }

        Iterator<String> iterator = list.iterator();
        iterator.remove();
    }

}
