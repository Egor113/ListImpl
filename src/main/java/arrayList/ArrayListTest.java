package arrayList;


public class ArrayListTest {

    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();
        for (int i = 0; i < 12; i++) {
            list.add("A");
        }
    }
}
