package task1;

public class MyArrayList<T> {

    /*    Необходимо написать свою реализацию коллекции на выбор LinkedList или ArrayList(можно оба варианта).
     Должны быть основные методы add, get, remove, addAll, остальное на ваше усмотрение
     */

    private static final int DEFAULT_CAPACITY = 10;

    transient Object[] elementData;         //тут будем хранить все элементы коллекции

    private int size;       //счетчик действительно хранящихся в массиве элементов

    public MyArrayList() {
    }


}
