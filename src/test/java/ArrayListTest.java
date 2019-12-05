import arrayList.MyArrayList;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ArrayListTest {
    //private static MyArrayList list;

//    @BeforeClass
//    public static void init(){
//        System.out.println("init MyArrayList");
//        list = new MyArrayList(5);
//    }

    @Test
    public void testAdd(){
        MyArrayList list = new MyArrayList(5);
        for (int i = 1; i <= 6; i++) {
            list.add(Integer.toString(i));
        }
        Assert.assertArrayEquals(new Object[]
                {"1","2","3","4","5","6",null,null},
                list.getElementData());
    }

    @Test
    public void testAddWithIndex(){
        MyArrayList list = new MyArrayList(5);
        for (int i = 1; i <= 6; i++) {
            list.add(Integer.toString(i));
        }

        list.add(2,"100");

        Assert.assertArrayEquals(new Object[]
                        {"1","2","100","3","4","5","6",null},
                list.getElementData());
    }


    @Test
    public void testRemove(){
        MyArrayList list = new MyArrayList(5);
        for (int i = 1; i <= 6; i++) {
            list.add(Integer.toString(i));
        }

        list.remove(4);
        Assert.assertArrayEquals(new Object[]
                        {"1","2","3","4","6",null,null,null},
                list.getElementData());
    }


}
