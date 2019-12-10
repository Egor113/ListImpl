package arrayListTest;

import arrayList.MyArrayList;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveByValueTest {

    @Test
    public void testRemoveByValue1(){
        MyArrayList<String> list = new MyArrayList<>(4);
        for (int i = 1; i <= 4; i++) {
            list.add(Integer.toString(i));
        }
        list.remove("3");

        ArrayList<String> testList = new ArrayList<>(Arrays.
                asList("1","2","4"));

        for (int i = 0; i < list.size(); i++) {
            Assert.assertEquals(testList.get(i),list.get(i));
        }
    }

    @Test
    public void testRemoveByValue2(){
        MyArrayList<String> list = new MyArrayList<>(4);
        for (int i = 1; i <= 4; i++) {
            list.add(Integer.toString(i));
        }
        Assert.assertFalse(list.remove("100"));
    }

    @Test
    public void testRemoveByValue3(){
        MyArrayList<String> list = new MyArrayList<>(4);
        for (int i = 1; i <= 4; i++) {
            list.add(Integer.toString(i));
        }
        ArrayList<String> testList = new ArrayList<>(Arrays.
                asList("1","2","3","4"));

        for (int i = 0; i < list.size(); i++) {
            Assert.assertEquals(testList.get(i),list.get(i));
        }
    }
}
