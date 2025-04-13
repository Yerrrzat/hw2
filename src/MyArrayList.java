import java.util.Iterator;

public class MyArrayList<T> implements MyList<T> {
    private Object[] data; // internal array to store elements
    private int size;      // current number of elements in the list

    public MyArrayList() {
        data = new Object[10]; // initial capacity
        size = 0;
    }

    @Override
    public void add(T item) {
        if (size == data.length) {
            grow(); // increase array capacity when it's full
        }
        data[size++] = item;
    }

    // Method to double the size of the internal array
    private void grow() {
        Object[] newData = new Object[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    // Placeholder methods to be implemented later
    @Override public T get(int index) { return null; }

    @Override public void remove(int index) {}

    @Override public int size() { return size; }

    @Override public void clear() {}

    @Override public boolean isEmpty() { return size == 0; }

    @Override public Iterator<T> iterator() { return null; }
}
