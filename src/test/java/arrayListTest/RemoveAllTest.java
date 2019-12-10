package arrayListTest;

import arrayList.MyArrayList;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveAllTest {

    @Test
    public void removeAllTest1(){
        MyArrayList<String> list = new MyArrayList<>(3);
        for (int i = 1; i <= 4; i++) {
            list.add(Integer.toString(i));
        }
        list.printArray();
        System.out.println();

        Set<String> set = new HashSet<>();
        set.add("1");
        set.add("2");

        list.removeAll(set);
        list.printArray();

        ArrayList<String> test = new ArrayList<>(Arrays.asList("3","4"));

        for (int i = 0; i < list.size(); i++) {
            Assert.assertEquals(test.get(i),list.get(i));
        }
    }

    @Test
    public void removeAllTest2(){
        MyArrayList<String> list = new MyArrayList<>(3);
        for (int i = 1; i <= 4; i++) {
            list.add(Integer.toString(i));
        }
        list.printArray();
        System.out.println();

        Set<String> set = new HashSet<>();
        set.add("100");
        set.add("200");

        list.removeAll(set);
        list.printArray();

        ArrayList<String> test = new ArrayList<>(Arrays.asList("1","2","3","4"));

        for (int i = 0; i < list.size(); i++) {
            Assert.assertEquals(test.get(i),list.get(i));
        }

    }

    @Test(expected = NullPointerException.class)
    public void removeAllTest3(){
        MyArrayList<String> list = new MyArrayList<>(3);
        for (int i = 1; i <= 4; i++) {
            list.add(Integer.toString(i));
        }

        Set<String> set = null;

        list.removeAll(set);

    }

}
