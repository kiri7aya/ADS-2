public class Main {
    public static void main(String[] args){
        MyStack<Integer> stack = new MyStack<>();

        stack.push(5);
        stack.push(10);
        stack.push(3);
        stack.push(8);

        System.out.println("Top element: " + stack.peek());

        while (!stack.isEmpty()) {
            System.out.println("Popped element: " + stack.pop());
        }

        MyQueue<Integer> queue = new MyQueue<>();

        queue.enqueue(5);
        queue.enqueue(10);
        queue.enqueue(3);
        queue.enqueue(8);

        while (!queue.isEmpty()) {
            System.out.println("Dequeued element: " + queue.dequeue());
        }

        MyMinHeap<Integer> heap = new MyMinHeap<>();

        heap.insert(5);
        heap.insert(10);
        heap.insert(3);
        heap.insert(8);

        while (!heap.isEmpty()) {
            System.out.println("Extracted min element: " + heap.extractMin());
        }
    }
}