package arrayListTest;

import arrayList.MyArrayList;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveByIndexTest {

    @Test
    public void removeByIndexTest1(){
        MyArrayList<String> list = new MyArrayList<>(5);
        for (int i = 1; i <= 6; i++) {
            list.add(Integer.toString(i));
        }

        list.remove(0);

        ArrayList<String> testList = new ArrayList<>(Arrays.
                asList("2","3","4","5","6"));

        for (int i = 0; i < list.size(); i++) {
            Assert.assertEquals(testList.get(i),list.get(i));
        }
    }

    @Test
    public void removeByIndexTest2(){
        MyArrayList<String> list = new MyArrayList<>(5);
        for (int i = 1; i <= 6; i++) {
            list.add(Integer.toString(i));
        }

        list.remove(4);

        ArrayList<String> testList = new ArrayList<>(Arrays.
                asList("1","2","3","4","6"));

        for (int i = 0; i < list.size(); i++) {
            Assert.assertEquals(testList.get(i),list.get(i));
        }

    }

    @Test
    public void removeByIndexTest3(){
        MyArrayList<String> list = new MyArrayList<>(5);
        for (int i = 1; i <= 6; i++) {
            list.add(Integer.toString(i));
        }
        list.remove(list.size() - 1);

        ArrayList<String> testList = new ArrayList<>(Arrays.
                asList("1","2","3","4","5"));

        for (int i = 0; i < list.size(); i++) {
            Assert.assertEquals(testList.get(i),list.get(i));
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeByIndexTest4(){
        MyArrayList<String> list = new MyArrayList<>(5);
        for (int i = 1; i <= 6; i++) {
            list.add(Integer.toString(i));
        }
        list.remove(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeByIndexTest5(){
        MyArrayList<String> list = new MyArrayList<>(5);
        for (int i = 1; i <= 6; i++) {
            list.add(Integer.toString(i));
        }
        list.remove(100);
    }

    @Test
    public void removeByIndexTest6(){
        MyArrayList<String> list = new MyArrayList<>(1);
        list.add("1");
        list.remove(0);
        Assert.assertEquals(0,list.size());
    }

}
