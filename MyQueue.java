package assignment2;

import java.util.NoSuchElementException;

public class MyQueue<E> {
    private MyDoublyLinkedList<E> queue;

    public MyQueue() {
        queue = new MyDoublyLinkedList<E>();
    }

    public void enqueue(E e) {
        queue.addLast(e);
    }

    public E dequeue() {
        if (queue.isEmpty()) {
            throw new NoSuchElementException("You can't dequeue an empty queue.");
        }
        return queue.removeFirst();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void clear() {
        queue.clear();
    }

    public boolean equals(Object o) {
        if (o instanceof MyQueue) {
            MyQueue<E> q = (MyQueue<E>) o;
            //q.queue.equals(this.queue);
            for (int i=0; i < this.queue.getSize(); i++) {
                E e1 = q.dequeue();
                q.enqueue(e1);
                E e2 = this.dequeue();
                this.enqueue(e2);
                if (e1 != e2) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

}
