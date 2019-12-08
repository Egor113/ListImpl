package linkedList;

import java.util.LinkedList;

public class LinkedListMain {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(i);
        }

    }
}
