public interface MyList<E> {
    void add(E item);
    void set(int index, E item);
    void add(int index, E item);
    void addFirst(E item);
    void addLast(E item);
    E get(int index);
    E getFirst();
    E getLast();
    void remove(int index);
    void removeFirst();
    void removeLast();
    void sort();
    int indexOf(Object object);
    int lastIndexOf(Object object);
    boolean exists(Object object);
    Object[] toArray();
    void clear();
    int size();
}