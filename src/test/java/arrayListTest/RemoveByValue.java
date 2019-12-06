package arrayListTest;

import arrayList.MyArrayList;
import org.junit.Assert;
import org.junit.Test;

public class RemoveByValue {

    @Test
    public void testRemoveByValue1(){
        MyArrayList<String> list = new MyArrayList<>(4);
        for (int i = 1; i <= 4; i++) {
            list.add(Integer.toString(i));
        }
        list.printArray();

        list.remove("3");
        Assert.assertArrayEquals(new Object[]{"1","2","4",null},
                list.getElementData());
        list.printArray();
    }

    @Test
    public void testRemoveByValue2(){
        MyArrayList<String> list = new MyArrayList<>(4);
        for (int i = 1; i <= 4; i++) {
            list.add(Integer.toString(i));
        }
        list.printArray();
        Assert.assertFalse(list.remove("100"));
        list.printArray();
    }

    @Test
    public void testRemoveByValue3(){
        MyArrayList<String> list = new MyArrayList<>(4);
        for (int i = 1; i <= 4; i++) {
            list.add(Integer.toString(i));
        }
        list.printArray();
        Assert.assertArrayEquals(new Object[]{"1","2","3","4"},
                list.getElementData());
        list.printArray();
    }
}
