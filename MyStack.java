package assignment2;

import java.util.NoSuchElementException;

public class MyStack<E> {
    private MyDoublyLinkedList<E> stack;

    public MyStack() {
        stack = new MyDoublyLinkedList<E>();
    }

    public void push(E e) {
        stack.addFirst(e);
    }

    public E pop() {
        if (stack.isEmpty()) {
            throw new NoSuchElementException("You can't pop from an empty stack.");
        }
        return stack.removeFirst();
    }

    public E peek() {
        return stack.peekFirst();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void clear() {
        stack.clear();
    }

    public int getSize() {
        return stack.getSize();
    }
}
