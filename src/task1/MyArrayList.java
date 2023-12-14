package task1;

import java.util.Arrays;
import java.util.Collection;

public class MyArrayList<T> {

    /*    Необходимо написать свою реализацию коллекции на выбор LinkedList или ArrayList(можно оба варианта).
     Должны быть основные методы add, get, remove, addAll, остальное на ваше усмотрение
     */

    private T[] arrList;                                //тут будем хранить все элементы коллекции c любым типом данных
    private int size;                                    //счетчик действительно хранящихся в массиве элементов
    private static final int DEFAULT_CAPACITY = 10;      //размер ArrayList по умолчанию

    private int capacity;
    public MyArrayList() {
        this.capacity = DEFAULT_CAPACITY;
        this.size = 0;
        arrList = (T[]) new Object[capacity];
    }

    public MyArrayList(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        arrList = (T[]) new Object[capacity];
    }

    public T get(int index){
        return arrList[index];
    }

    public void set(int index, T item){
        arrList[index] = item;
    }
    public void add(T newElem){
        if (size + 1 > capacity) {
            T[] newArr =  (T[]) new Object[capacity * 2];
            System.arraycopy(arrList, 0, newArr, 0, arrList.length);
            arrList = newArr;
        }
        arrList[size++] = newElem;
    }

    public void remove(int index){
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        for(int i = index; i < size; i++){
            arrList[i] = arrList[i+1];
        }
        size--;
    }

    public boolean addAll(Collection<? extends T> collections) {
        for (T el : collections) {
            add(el);
        }
        return true;
    }

    public int size () {
        return size;
    }

    public void printArrList(){
        for(T el : arrList){
            System.out.println(el + " ");
        }
    }


    @Override
    public String toString() {
        return Arrays.toString(arrList) +
                ", size=" + size +
                '}';
    }
}
