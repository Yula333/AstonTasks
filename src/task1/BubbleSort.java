package task1;

import java.util.Arrays;

public class BubbleSort {

    /* Написать реализацию сортировки пузырьком с флагом, который прекращает сортировку,
       если коллекция уже отсортирована.*/

    public static int[] bubbleSort(int [] arr) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for(int i = 1; i < arr.length; i++){
                if (arr[i] < arr[i-1]){
                    int tmp = arr[i-1];
                    arr[i-1] = arr[i];
                    arr[i] = tmp;
                    isSorted = false;
                }
            }
        }
        return arr;
    }
}
