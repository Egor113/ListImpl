package linkedList;

import java.util.*;

public class LinkedListMain {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);


        System.out.println();

        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < 3; i++) {
            set.add(i * 100);
        }

        for (int i: set) {
            System.out.print(i + " ");
        }

        System.out.println();
        list.addAll(set);


        for (int i: list) {
            System.out.print(i + " ");
        }

    }

}
