package arrayListTest;

import arrayList.MyArrayList;
import org.junit.Assert;
import org.junit.Test;

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
        list.addAll(1,set);

        Assert.assertArrayEquals(new Object[]
                        {"1","100","200","300","2","3","4","5","6",null,null,null,null,null},
                list.getElementData());

        list.printArray();
    }

    @Test(expected = NullPointerException.class)
    public void testAddAllWithIndex2(){
        MyArrayList<String> list = new MyArrayList<>(3);
        list.add("1");
        Set<String> set = null;
        list.addAll(0,set);
    }

    @Test
    public void testAddAllWithIndex3(){
        MyArrayList<String> list = new MyArrayList<>(3);
        for (int i = 1; i <= 3; i++) {
            list.add(Integer.toString(i));
        }
        list.printArray();

        Set<String> set = new HashSet<>();

        list.addAll(2,set);
        Assert.assertArrayEquals(new Object[]{"1","2","3"},
                list.getElementData());

        list.printArray();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllWithIndex4(){
        MyArrayList<String> list = new MyArrayList<>(1);
        list.add("1");
        Set<String> set = new HashSet<>();
        list.addAll(2,set);
    }

}
