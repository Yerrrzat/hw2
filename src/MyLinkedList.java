import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T> {
    private static class Node<T> {
        T value;
        Node<T> next;
        Node<T> prev;
        Node(T value) { this.value = value; }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public MyLinkedList() {
        head = tail = null;
        size = 0;
    }

    @Override
    public void add(T item) {
        addLast(item);
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index == size) {
            addLast(item);
            return;
        }
        if (index == 0) {
            addFirst(item);
            return;
        }
        Node<T> node = getNode(index);
        Node<T> newNode = new Node<>(item);
        Node<T> prev = node.prev;
        prev.next = newNode;
        newNode.prev = prev;
        newNode.next = node;
        node.prev = newNode;
        size++;
    }

    @Override
    public void addFirst(T item) {
        Node<T> newNode = new Node<>(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    @Override
    public void addLast(T item) {
        Node<T> newNode = new Node<>(item);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public T get(int index) {
        return getNode(index).value;
    }

    @Override
    public T getFirst() {
        return get(0);
    }

    @Override
    public T getLast() {
        return get(size - 1);
    }

    @Override
    public void remove(int index) {
        Node<T> node = getNode(index);
        Node<T> prev = node.prev;
        Node<T> next = node.next;
        if (prev != null) {
            prev.next = next;
        } else {
            head = next;
        }
        if (next != null) {
            next.prev = prev;
        } else {
            tail = prev;
        }
        size--;
    }

    @Override
    public void removeFirst() {
        remove(0);
    }

    @Override
    public void removeLast() {
        remove(size - 1);
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    private Node<T> getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<T> curr;
        if (index < size / 2) {
            curr = head;
            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }
        } else {
            curr = tail;
            for (int i = size - 1; i > index; i--) {
                curr = curr.prev;
            }
        }
        return curr;
    }

    @Override
    public void set(int index, T item) {
        Node<T> node = getNode(index);
        node.value = item;
    }

    @Override
    public int indexOf(Object o) {
        Node<T> curr = head;
        int idx = 0;
        while (curr != null) {
            if (o == null ? curr.value == null : o.equals(curr.value)) {
                return idx;
            }
            curr = curr.next;
            idx++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        Node<T> curr = tail;
        int idx = size - 1;
        while (curr != null) {
            if (o == null ? curr.value == null : o.equals(curr.value)) {
                return idx;
            }
            curr = curr.prev;
            idx--;
        }
        return -1;
    }

    @Override
    public boolean exists(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        Node<T> curr = head;
        int i = 0;
        while (curr != null) {
            array[i++] = curr.value;
            curr = curr.next;
        }
        return array;
    }

    @Override
    public void sort() {
        if (size < 2) return;
        boolean swapped;
        do {
            swapped = false;
            Node<T> curr = head;
            while (curr.next != null) {
                Comparable<? super T> a = (Comparable<? super T>) curr.value;
                T b = curr.next.value;
                if (a.compareTo(b) > 0) {
                    T tmp = curr.value;
                    curr.value = curr.next.value;
                    curr.next.value = tmp;
                    swapped = true;
                }
                curr = curr.next;
            }
        } while (swapped);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> curr = head;
            @Override
            public boolean hasNext() {
                return curr != null;
            }
            @Override
            public T next() {
                T val = curr.value;
                curr = curr.next;
                return val;
            }
        };
    }
}
