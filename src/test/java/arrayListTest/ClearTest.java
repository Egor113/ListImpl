package arrayListTest;

import arrayList.MyArrayList;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class ClearTest {

    @Test
    public void clearTest(){
        MyArrayList<String> list = new MyArrayList<>(5);
        for (int i = 1; i <= 6; i++) {
            list.add(Integer.toString(i));
        }
        list.printArray();

        list.clear();

        Assert.assertEquals(0, list.size());

        list.printArray();
    }

}
