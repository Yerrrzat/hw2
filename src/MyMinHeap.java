import java.util.Iterator;

public class MyMinHeap<T extends Comparable<? super T>> implements Iterable<T> {
    private Object[] data;
    private int size;

    public MyMinHeap() {
        data = new Object[10];
        size = 0;
    }

    public void add(T item) {
        if (size == data.length) grow();
        data[size] = item;
        siftUp(size++);
    }

    public T peek() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        return (T) data[0];
    }

    public T extractMin() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        T min = (T) data[0];
        data[0] = data[--size];
        data[size] = null;
        siftDown(0);
        return min;
    }

    public int size() {
        return size;
    }

    private void grow() {
        Object[] newData = new Object[data.length * 2];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }

    private void siftUp(int idx) {
        while (idx > 0) {
            int parent = (idx - 1) / 2;
            @SuppressWarnings("unchecked")
            T curr = (T) data[idx];
            @SuppressWarnings("unchecked")
            T par = (T) data[parent];
            if (curr.compareTo(par) >= 0) break;
            data[idx] = par;
            data[parent] = curr;
            idx = parent;
        }
    }

    private void siftDown(int idx) {
        while (true) {
            int left = 2 * idx + 1;
            int right = 2 * idx + 2;
            int smallest = idx;
            if (left < size && ((Comparable<? super T>) data[left]).compareTo((T) data[smallest]) < 0) {
                smallest = left;
            }
            if (right < size && ((Comparable<? super T>) data[right]).compareTo((T) data[smallest]) < 0) {
                smallest = right;
            }
            if (smallest == idx) break;
            Object tmp = data[idx];
            data[idx] = data[smallest];
            data[smallest] = tmp;
            idx = smallest;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int cursor = 0;

            @Override
            public boolean hasNext() {
                return cursor < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new IllegalStateException("No more elements");
                }
                return (T) data[cursor++];
            }
        };
    }
}
