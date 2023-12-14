package task1;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        MyArrayList<Integer> myArr = new MyArrayList<>();
        myArr.add(5);
        myArr.add(7);
        myArr.add(15);
        myArr.add(1);
        myArr.add(4);

        ArrayList<Integer> collection = new ArrayList<>();
        for (int i = 10; i >= 1; i--) {
            collection.add(i);
        }
        System.out.println(myArr);
        myArr.remove(3);
        myArr.set(0, 50);
        System.out.println(myArr);
        myArr.addAll(collection);
        System.out.println(myArr);
    }
}
