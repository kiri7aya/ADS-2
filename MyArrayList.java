public class MyArrayList<E> implements MyList<E> {
    private static final int default_capacity = 10;
    private Object[] elements;
    private int size;

    public MyArrayList() {
        this.elements = new Object[default_capacity];
        this.size = 0;
    }

    // Method to increase capacity

    private void increaseCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            int newCapacity = Math.max(minCapacity, elements.length * 2);
            Object[] newArray = new Object[newCapacity];
            for(int i = 0; i < size; i++) {
                newArray[i] = elements[i];
            }
            elements = newArray;
        }
    }

    // Method to check if list is empty

    private boolean isEmpty() {
        return size == 0;
    }

    // Using method from interface MyList

    public void add(E item) {
        increaseCapacity(size + 1);
        elements[size++] = item;
    }
    public void set(int index, E item) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        elements[index] = item;
    }
    public void add(int index, E item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        increaseCapacity(size + 1);
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = item;
        size++;
    }
    public void addFirst(E item) {
        add(0, item);
    }
    public void addLast(E item) {
        add(size, item);
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return (E) elements[index];
    }

    public E getFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        return (E) elements[0];
    }

    public E getLast() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        return (E) elements[size - 1];
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--size] = null;
    }

    public void removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        remove(0);
    }

    public void removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        remove(size - 1);
    }

    public void sort() {
        // Not implemented for this version
        throw new UnsupportedOperationException("Sorting is not supported");
    }

    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (object.equals(elements[i])) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object object) {
        for (int i = size - 1; i >= 0; i--) {
            if (object.equals(elements[i])) {
                return i;
            }
        }
        return -1;
    }

    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    public Object[] toArray() {
        Object[] array = new Object[size];
        for (int i = 0; i < size; i++) {
            array[i] = elements[i];
        }
        return array;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    public int size() {
        return size;
    }
}