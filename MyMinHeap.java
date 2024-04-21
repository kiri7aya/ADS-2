public class MyMinHeap<E extends Comparable<E>> {
    private MyList<E> elements;

    public MyMinHeap() {
        elements = new MyArrayList<>();
    }

    public boolean isEmpty() {
        return elements.size() == 0;
    }

    //insert element and swap with parenr element if new insert less than parent element
    public void insert(E element) {
        elements.add(element);
        heapifyUp(elements.size() - 1);
    }

    //delete first element which are min due to heapifying up at the process of insert and put last element at the first position
    public E extractMin() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        E min = elements.get(0);
        E lastElement = elements.getLast();
        elements.removeLast();
        if (!isEmpty()) {
            elements.set(0, lastElement);
            heapifyDown(0);
        }
        return min;
    }

    // compare parent element of inserted element
    //if it is less than parent element swap them
    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (elements.get(index).compareTo(elements.get(parentIndex)) >= 0) {
                break;
            }
            swap(index, parentIndex);
            index = parentIndex;
        }
    }

    private void heapifyDown(int index) {
        int smallest = index;
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;

        if (leftChild < elements.size() && elements.get(leftChild).compareTo(elements.get(smallest)) < 0) {
            smallest = leftChild;
        }
        if (rightChild < elements.size() && elements.get(rightChild).compareTo(elements.get(smallest)) < 0) {
            smallest = rightChild;
        }

        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }

    private void swap(int i, int j) {
        E temp = elements.get(i);
        elements.set(i, elements.get(j));
        elements.set(j, temp);
    }
}