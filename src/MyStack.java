import java.util.Iterator;

public class MyStack<T> implements Iterable<T> {
    private MyLinkedList<T> list = new MyLinkedList<>();

    public void push(T item) {
        list.addLast(item);
    }

    public T pop() {
        if (list.size() == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        T val = list.getLast();
        list.removeLast();
        return val;
    }

    public T peek() {
        if (list.size() == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        return list.getLast();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}
