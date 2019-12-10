package arrayListTest;

import arrayList.MyArrayList;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class AddWithIndexTest {

    @Test
    public void testAddWithIndex1(){
        MyArrayList<String> list = new MyArrayList<>(5);

        for (int i = 1; i <= 7; i++) {
            list.add(Integer.toString(i));
        }

        list.add(0,"100");

        ArrayList<String> testList = new ArrayList<>(Arrays.
                asList("100","1","2","3","4","5","6","7"));

        for (int i = 0; i < list.size(); i++) {
            Assert.assertEquals(testList.get(i),list.get(i));
        }
    }

    @Test
    public void testAddWithIndex2(){
        MyArrayList<String> list = new MyArrayList<>(5);

        for (int i = 1; i <= 7; i++) {
            list.add(Integer.toString(i));
        }

        list.add(3,"100");

        ArrayList<String> testList = new ArrayList<>(Arrays.
                asList("1","2","3","100","4","5","6","7"));

        for (int i = 0; i < list.size(); i++) {
            Assert.assertEquals(testList.get(i),list.get(i));
        }
    }

    @Test
    public void testAddWithIndex3(){
        MyArrayList<String> list = new MyArrayList<>(5);

        for (int i = 1; i <= 7; i++) {
            list.add(Integer.toString(i));
        }

        list.add(list.size(),"100");

        ArrayList<String> testList = new ArrayList<>(Arrays.
                asList("1","2","3","4","5","6","7","100"));

        for (int i = 0; i < list.size(); i++) {
            Assert.assertEquals(testList.get(i),list.get(i));
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddWithIndex4(){
        MyArrayList<String> list = new MyArrayList<>(5);
        list.add(-1,"100");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddWithIndex5(){
        MyArrayList<String> list = new MyArrayList<>(5);
        list.add(6,"100");
    }
}
