import arrayList.MyArrayList;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class ArrayListTest {

    @Test
    public void testAdd(){
        MyArrayList<String> list = new MyArrayList<>(5);
        for (int i = 1; i <= 6; i++) {
            list.add(Integer.toString(i));
        }

        list.printArray();
        Assert.assertArrayEquals(new Object[]
                {"1","2","3","4","5","6",null,null},
                list.getElementData());
    }

    @Test
    public void testAddWithIndex(){
        MyArrayList<String> list = new MyArrayList<>(5);
        for (int i = 1; i <= 6; i++) {
            list.add(Integer.toString(i));
        }

        list.printArray();
        list.add(2,"100");

        Assert.assertArrayEquals(new Object[]
                        {"1","2","100","3","4","5","6",null},
                list.getElementData());
    }


    @Test
    public void testRemove(){
        MyArrayList<String> list = new MyArrayList<>(5);
        for (int i = 1; i <= 6; i++) {
            list.add(Integer.toString(i));
        }
        list.printArray();

        list.remove(4);
        Assert.assertArrayEquals(new Object[]
                        {"1","2","3","4","6",null,null,null},
                list.getElementData());
    }

    @Test
    public void testRemoveWithValue(){
        MyArrayList<String> list = new MyArrayList<>(5);
        for (int i = 1; i <= 6; i++) {
            list.add(Integer.toString(i));
        }
        list.printArray();

        list.remove("3");
        Assert.assertArrayEquals(new Object[]
                        {"1","2","4","5","6",null,null,null},
                list.getElementData());
    }

    @Test
    public void testAddAll(){
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
            System.out.println(s);
        }

        list.addAll(set);

        Assert.assertArrayEquals(new Object[]
                        {"1","2","3","4","5","6","100","200","300",null,null,null,null,null},
                list.getElementData());

        list.printArray();
    }


}
