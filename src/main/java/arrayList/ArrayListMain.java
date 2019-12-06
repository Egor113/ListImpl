package arrayList;


import java.util.*;

public class ArrayListMain {

    public static void main(String[] args) {

        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, null, 3,4, 5));

//        for (int i = 0; i < list1.size(); i++) {
//            System.out.println(list1.get(i));
//        }

        list1.add(5,1);


    }
}
