package arrayListTest;

import arrayList.MyArrayList;
import org.junit.Assert;
import org.junit.Test;

public class AddWithIndexTest {

    @Test
    public void testAddWithIndex1(){
        MyArrayList<String> list = new MyArrayList<>(5);

        for (int i = 1; i <= 7; i++) {
            list.add(Integer.toString(i));
        }

        list.printArray();
        list.add(2,"100");

        Assert.assertArrayEquals(new Object[]
                        {"1","2","100","3","4","5","6","7"},
                list.getElementData());
        list.printArray();
    }

    @Test
    public void testAddWithIndex2(){
        MyArrayList<String> list = new MyArrayList<>(3);

        for (int i = 1; i <= 3; i++) {
            list.add(Integer.toString(i));
        }

        list.printArray();
        list.add(1,null);

        Assert.assertArrayEquals(new Object[]{"1",null,"2","3",null},
                list.getElementData());
        list.printArray();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddWithIndex3(){
        MyArrayList<String> list = new MyArrayList<>(5);
        list.add(-1,"100");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddWithIndex4(){
        MyArrayList<String> list = new MyArrayList<>(5);
        list.add(6,"100");
    }
}
