import java.util.Iterator;

public class MyQueue<T> implements Iterable<T> {
    private MyLinkedList<T> list = new MyLinkedList<>();

    public void enqueue(T item) {
        list.addLast(item);
    }

    public T dequeue() {
        if (list.size() == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        T val = list.getFirst();
        list.removeFirst();
        return val;
    }

    public T peek() {
        if (list.size() == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        return list.getFirst();
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
