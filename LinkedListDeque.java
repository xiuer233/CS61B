public class LinkedListDeque<T> {
    public class Node {
        private T item;
        private Node pre;
        private Node next;

        /* constructor for Node*/
        public Node(T n, Node _pre, Node _next) {
            item = n;
            pre = _pre;
            next = _next;
        }

        public Node(Node _pre, Node _next) {
            pre = _pre;
            next = _next;
        }
    }

    /* sentinal node at the front */
    private Node sentitialF;
    /* sentinal node at the end */
    private Node sentitialE;
    /* size of the deque */
    private int size;

    /* constructor for LinkedListDeque */
    public LinkedListDeque() {
        sentitialF = new Node(null, null);
        sentitialE = new Node(sentitialF, sentitialF);
        sentitialF.pre = sentitialE;
        sentitialF.next = sentitialE;
        size = 0;
    }

    public void addFirst(T item) {
        Node tmp = sentitialF.next;
        sentitialF.next = new Node(item, sentitialF, sentitialF.next);
        tmp.pre = sentitialF.next;
        size++;
    }

    public void addLast(T item) {
        Node tmp = sentitialE.pre;
        sentitialE.pre = new Node(item, sentitialE.pre, sentitialE);
        tmp.next = sentitialE.pre;
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
        Node tmp = sentitialF.next;
        while (tmp != sentitialE) {
            System.out.println(tmp.item);
            tmp = tmp.next;
        }
    }

    public T removeFirst() {
        Node tmp = sentitialF.next;
        if (tmp == sentitialE) {
            return null;
        }
        // 注意这里因为是双边链表，所以不仅要考虑next, 还要改动pre
        sentitialF.next = tmp.next;
        tmp.next.pre = sentitialF;
        size--;
        return tmp.item;
    }

    public T removeLast() {
        Node tmp = sentitialE.pre;
        if (tmp == sentitialF) {
            return null;
        }
        sentitialE.pre = tmp.pre;
        tmp.pre.next = sentitialE;
        size--;
        return tmp.item;
    }

    public T get(int index) {
        Node tmp = sentitialF.next;
        for (int i = 0; i < index; i++){
            tmp = tmp.next;
        }
        return tmp.item;
    }

    public T getRecursive(int index) {
        return Recursive(index).item;
    }

    public Node Recursive(int index) {
        if (index == 0) {
            return sentitialF.next;
        }
        else {
            return Recursive(index - 1).next;
        }
    }
}
