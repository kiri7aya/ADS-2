public class MyQueue<E> {
    private MyList<E> list;

    public MyQueue() {
        list = new MyLinkedList<>();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public E peek() {
        if (list.exists(list)) {
            throw new IllegalStateException("Queue is empty");
        }
        return list.get(list.size()-1);
    }

    // enqueue(insertion)
    public E enqueue(E element) {
        list.addFirst(element);
        return element;
    }

    //dequeue(deletion)
    public E dequeue() {
        if (list.exists(list)) {
            throw new IllegalStateException("Queue is empty");
        }
        E removingElement = peek();
        list.removeLast();
        return removingElement;
    }
}