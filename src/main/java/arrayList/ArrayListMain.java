package arrayList;


import java.util.*;

public class ArrayListMain {

    public static void main(String[] args) {

        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3,4, 5));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(1, 5));
        list1.removeAll(list2);
        for (int i: list1) {
            System.out.print(i + " ");
        }


    }
}
