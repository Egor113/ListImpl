package arrayList;


public class ArrayListTest {

    public static void main(String[] args) throws Exception {
        MyArrayList<String> list = new MyArrayList<>(3);
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        //list.add(2,"100");
        list.printArray();
        list.remove(3);
        System.out.println();
        list.printArray();


    }
}
