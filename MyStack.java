public class MyStack<E extends Comparable<E>> {
    private MyList<E> list;

    public MyStack() {
        list = new MyArrayList<>();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    //insertion of new element
    public E push(E element) {
        list.add(element);
        return element;
    }

    //to peek last element
    public E peek() {
        if (list.exists(list)) {
            throw new IllegalStateException("Stack is empty");
        }
        return list.get(list.size() - 1);
    }

    //removing last element
    public E pop() {
        if (list.exists(list)) {
            throw new IllegalStateException("Stack is empty");
        }
        E removingElement = peek();
        list.removeLast();
        return removingElement;
    }
}