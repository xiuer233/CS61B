public class ArrayDeque<T> {
    private int size;
    private T[] items;
    private int first;
    private int last;
    private int length;

    public ArrayDeque() {
        size = 0;
        items = (T[]) new Object[8];
        first = 4;
        last = 3;
        length = 8;
    }

    public int circularPlus(int n) {
        if (n >= length) {
            return length - n;
        }
        else {
            return n + 1;
        }
    }
    public int circularMinus(int n) {
        if (n < 0) {
            return length + n;
        }
        else {
            return n - 1;
        }
    }
    public void addFirst(T item) {
        if (size == length - 1) {
            grow();
        }
        first = circularMinus(first);
        items[first] = item;
        size++;
    }
    public void addLast(T item) {
        if (size == length - 1) {
            grow();
        }
        last = circularPlus(last);
        items[last] = item;
        size++;
    }
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        System.out.println("The elements in Array Deque is listed below\n");
        int begin = first, end = last;
        while (begin != end) {
            System.out.println(items[begin] + " ");
            begin = circularPlus(begin);
        }
        //System.out.println(items[begin]);

    }

    public T getFirst() {
        return items[first];
    }

    public T getLast() {
        return items[last];
    }

    public T removeFirst() {
        T x = getFirst();
        first = circularPlus(first);
        size--;
        if (size == length / 4) {
            shrink();
        }
        return x;
    }

    public T removeLast() {
        T x = getLast();
        last = circularMinus(last);
        size--;
        if (size == length / 4) {
            shrink();
        }
        return x;
    }

    public T get(int index) {
        return items[index];
    }

    public void grow() {
        T[] a = (T[]) new Object[length * 2];
        items = arrayCopy(items, a, length * 2);
        length *= 2;

    }
    public void shrink() {
        T[] a = (T[]) new Object[length / 2];
        items = arrayCopy(items, a, length / 2);
        length /= 2;
    }
    public T[] arrayCopy(T[] before, T[] after, int length) {
        int pointer = length/4;
        int begin = first, end = last;
        while (begin != end) {
            after[pointer] = before[begin];
            begin = circularPlus(begin);
            pointer++;
        }
        after[pointer] = before[begin];
        first = length/4;
        last = first + size;
        return after;
    }

}
