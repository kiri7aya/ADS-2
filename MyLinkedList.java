public class MyLinkedList<E> implements MyList<E> {
    private static class MyNode<E> {
        E element;
        MyNode<E> next;
        MyNode<E> prev;

        MyNode(E element, MyNode<E> prev, MyNode<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }

    private MyNode<E> head;
    private MyNode<E> tail;
    private int size;

    //Initialize linked list where head and tail are null by default
    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // Method to get node at index

    private MyNode<E> getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        MyNode<E> current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current;
    }

    // Method to disable node from list

    private void disable(MyNode<E> node) {
        MyNode<E> pred = node.prev;
        MyNode<E> succ = node.next;

        if (pred == null) {
            head = succ;
        } else {
            pred.next = succ;
            node.prev = null;
        }

        if (succ == null) {
            tail = pred;
        } else {
            succ.prev = pred;
            node.next = null;
        }

        node.element = null;
        size--;
    }

    // Method to check if list is empty

    private boolean isEmpty() {
        return size == 0;
    }

    // Implementing methods from MyList interface

    public void add(E item) {
        addLast(item);
    }

    public void set(int index, E item) {
        getNode(index).element = item;
    }

    public void add(int index, E item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (index == size) {
            addLast(item);
        } else if (index == 0) {
            addFirst(item);
        } else {
            MyNode<E> succ = getNode(index);
            MyNode<E> pred = succ.prev;
            MyNode<E> newNode = new MyNode<>(item, pred, succ);
            succ.prev = newNode;
            pred.next = newNode;
            size++;
        }
    }

    public void addFirst(E item) {
        if (isEmpty()) {
            head = tail = new MyNode<>(item, null, null);
        } else {
            MyNode<E> newNode = new MyNode<>(item, null, head);
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(E item) {
        if (isEmpty()) {
            head = tail = new MyNode<>(item, null, null);
        } else {
            MyNode<E> newNode = new MyNode<>(item, tail, null);
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public E get(int index) {
        return getNode(index).element;
    }

    public E getFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        return head.element;
    }

    public E getLast() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        return tail.element;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        MyNode<E> nodeToRemove = getNode(index);
        disable(nodeToRemove);
    }

    public void removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        disable(head);
    }

    public void removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        disable(tail);
    }

    public void sort() {
        throw new UnsupportedOperationException("Sorting is not supported for linked list");
    }

    public int indexOf(Object object) {
        int index = 0;
        for (MyNode<E> current = head; current != null; current = current.next) {
            if (object.equals(current.element)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public int lastIndexOf(Object object) {
        int index = size - 1;
        for (MyNode<E> current = tail; current != null; current = current.prev) {
            if (object.equals(current.element)) {
                return index;
            }
            index--;
        }
        return -1;
    }

    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    public Object[] toArray() {
        Object[] array = new Object[size];
        int index = 0;
        for (MyNode<E> current = head; current != null; current = current.next) {
            array[index++] = current.element;
        }
        return array;
    }

    public void clear() {
        while (head != null) {
            MyNode<E> next = head.next;
            head.prev = null;
            head.next = null;
            head = next;
        }
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }
}