package arrayListTest;

import arrayList.MyArrayList;
import org.junit.Assert;
import org.junit.Test;

public class AddTest {

    @Test
    public void addTest1(){

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
    public void addTest2(){

        MyArrayList<String> list = new MyArrayList<>(2);
        list.add("1");
        list.add(null);

        list.printArray();
        Assert.assertArrayEquals(new Object[]{"1",null},list.getElementData());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addTest3(){
        MyArrayList<String> list = new MyArrayList<>(-1);
    }
}
