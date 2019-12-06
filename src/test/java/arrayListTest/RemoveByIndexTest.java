package arrayListTest;

import arrayList.MyArrayList;
import org.junit.Assert;
import org.junit.Test;

public class RemoveByIndexTest {

    @Test
    public void removeByIndexTest1(){
        MyArrayList<String> list = new MyArrayList<>(5);
        for (int i = 1; i <= 6; i++) {
            list.add(Integer.toString(i));
        }
        list.printArray();

        list.remove(4);
        Assert.assertArrayEquals(new Object[]
                        {"1","2","3","4","6",null,null,null},
                list.getElementData());
        list.printArray();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeByIndexTest2(){
        MyArrayList<String> list = new MyArrayList<>(5);
        for (int i = 1; i <= 6; i++) {
            list.add(Integer.toString(i));
        }
        list.remove(-1);
    }

    @Test
    public void removeByIndexTest3(){
        MyArrayList<String> list = new MyArrayList<>(1);
        list.add("1");
        list.printArray();
        list.remove(0);
        Assert.assertArrayEquals(new Object[]{null},list.getElementData());
        list.printArray();
    }

}
