package arrayListTest;

import arrayList.MyArrayList;
import org.junit.Assert;
import org.junit.Test;

public class GetTest {

    @Test
    public void getTest1(){

        MyArrayList<String> list = new MyArrayList<>(5);
        list.add("1");
        Assert.assertEquals("1",list.get(0));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getTest2(){

        MyArrayList<String> list = new MyArrayList<>(5);
        list.add("1");
        list.get(1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getTest3(){

        MyArrayList<String> list = new MyArrayList<>(5);
        list.get(0);
    }

}
