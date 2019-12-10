package arrayListTest;

import arrayList.MyArrayList;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class AddTest {

    @Test
    public void addTest1(){

        MyArrayList<String> list = new MyArrayList<>(0);
        for (int i = 1; i <= 6; i++) {
            list.add(Integer.toString(i));
        }

        ArrayList<String> testList = new ArrayList<>(Arrays.
                asList("1","2","3","4","5","6"));

        for (int i = 0; i < list.size(); i++) {
            Assert.assertEquals(testList.get(i),list.get(i));
        }
    }

    @Test
    public void addTest2(){

        MyArrayList<String> list = new MyArrayList<>(2);
        list.add("1");
        list.add(null);

        Assert.assertEquals("1",list.get(0));
        Assert.assertNull(list.get(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addTest3(){
        MyArrayList<String> list = new MyArrayList<>(-1);
    }
}
