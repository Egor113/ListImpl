package linkedList;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class LinkedListMain2 {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 4; i++) {
            list.add(i);
        }

        System.out.println();

        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < 4; i++) {
            set.add(i * 100);
        }
        for (int i: set) {
            System.out.print(i + " ");
        }
        System.out.println();
        list.addAll(0,set);


        for (int i: list) {
            System.out.print(i + " ");
        }

    }

}
