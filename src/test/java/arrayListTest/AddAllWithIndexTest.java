package arrayListTest;

import arrayList.MyArrayList;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AddAllWithIndexTest {

    @Test
    public void AddAllWithIndexTest1(){
        MyArrayList<String> list = new MyArrayList<>(5);
        for (int i = 1; i <= 6; i++) {
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
        list.addAll(0,set);

        ArrayList<String> testList = new ArrayList<>(Arrays.
                asList("100","200","300","1","2","3","4","5","6"));

        for (int i = 0; i < list.size(); i++) {
            Assert.assertEquals(testList.get(i),list.get(i));
        }

        list.printArray();
    }

    @Test
    public void AddAllWithIndexTest2(){
        MyArrayList<String> list = new MyArrayList<>(5);
        for (int i = 1; i <= 6; i++) {
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
        list.addAll(2,set);

        ArrayList<String> testList = new ArrayList<>(Arrays.
                asList("1","2","100","200","300","3","4","5","6"));

        for (int i = 0; i < list.size(); i++) {
            Assert.assertEquals(testList.get(i),list.get(i));
        }

        list.printArray();
    }

    @Test
    public void AddAllWithIndexTest3(){
        MyArrayList<String> list = new MyArrayList<>(5);
        for (int i = 1; i <= 6; i++) {
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
        list.addAll(list.size(),set);

        ArrayList<String> testList = new ArrayList<>(Arrays.
                asList("1","2","3","4","5","6","100","200","300"));

        for (int i = 0; i < list.size(); i++) {
            Assert.assertEquals(testList.get(i),list.get(i));
        }

        list.printArray();
    }

    @Test(expected = NullPointerException.class)
    public void testAddAllWithIndex4(){
        MyArrayList<String> list = new MyArrayList<>(3);
        list.add("1");
        Set<String> set = null;
        list.addAll(0,set);
    }

    @Test
    public void testAddAllWithIndex5(){
        MyArrayList<String> list = new MyArrayList<>(3);
        for (int i = 1; i <= 3; i++) {
            list.add(Integer.toString(i));
        }
        list.printArray();

        Set<String> set = new HashSet<>();

        ArrayList<String> testList = new ArrayList<>(Arrays.asList("1","2","3"));

        for (int i = 0; i < list.size(); i++) {
            Assert.assertEquals(testList.get(i),list.get(i));
        }

        list.printArray();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllWithIndex6(){
        MyArrayList<String> list = new MyArrayList<>(1);
        list.add("1");
        Set<String> set = new HashSet<>();
        list.addAll(2,set);
    }

}
