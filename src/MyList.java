public interface MyList<T> extends Iterable<T> {
    void add(T item);

    void add(int index, T item);

    void addFirst(T item);

    void addLast(T item);

    T get(int index);

    T getFirst();

    T getLast();

    void remove(int index);
    int size();

    void removeFirst();

    void removeLast();

    void clear();

    void set(int index, T item);

    void sort();

    int indexOf(Object object);

    int lastIndexOf(Object object);

    boolean exists(Object object);

    Object[] toArray();
}
