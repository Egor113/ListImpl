package arrayListTest;

import arrayList.MyArrayList;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AddAllTest {

    @Test
    public void testAddAll1(){
        MyArrayList<String> list = new MyArrayList<>(3);
        for (int i = 1; i <= 4; i++) {
            list.add(Integer.toString(i));
        }
        list.printArray();

        Set<String> set = new HashSet<>();
        set.add("100");
        set.add("200");
        set.add("300");

        for (String s: set) {
            System.out.print(s + " ");
        }
        System.out.println();
        list.addAll(set);
        ArrayList<String> test = new ArrayList<>(Arrays.
                asList("1","2","3","4","100","200","300",null,null,null,null));

        for (int i = 0; i < list.size(); i++) {
            Assert.assertEquals(test.get(i),list.get(i));
        }

        list.printArray();
    }

    @Test(expected = NullPointerException.class)
    public void testAddAll2(){
        MyArrayList<String> list = new MyArrayList<>(3);
        Set<String> set = null;
        list.addAll(set);
    }

    @Test
    public void testAddAll3(){
        MyArrayList<String> list = new MyArrayList<>(3);
        for (int i = 1; i <= 4; i++) {
            list.add(Integer.toString(i));
        }
        list.printArray();

        Set<String> set = new HashSet<>();

        list.addAll(set);

        ArrayList<String> test = new ArrayList<>(Arrays.asList("1","2","3","4",null));

        for (int i = 0; i < list.size(); i++) {
            Assert.assertEquals(test.get(i),list.get(i));
        }


        list.printArray();
    }

    @Test
    public void testAddAll4(){
        MyArrayList<String> list = new MyArrayList<>(3);
        for (int i = 1; i <= 4; i++) {
            list.add(Integer.toString(i));
        }
        list.printArray();

        Set<String> set = new HashSet<>();

        list.addAll(set);

        Assert.assertFalse( list.addAll(set));

        list.printArray();
    }


}
