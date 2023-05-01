package assignment2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyDoublyLinkedList<E> extends MyLinkedList<E> {
    private DNode head;
    private DNode tail;

    public void addFirst(E e) {
        if (this.size==0){
            DNode temp = new DNode();
            temp.element = e;
            head = temp;
            tail = temp;
        }
        DNode temp = head;
        head = new DNode();
        head.element = e;
        head.next = temp;
        temp.prev = head;
        size ++;
    }
    public void add(E e) {
        if (this.size==0){
            DNode temp = new DNode();
            temp.element = e;
            head = temp;
            tail = temp;
        } else {
            DNode temp = tail;
            temp.next = new DNode();
            temp.next.element = e;
            tail = temp.next;
            tail.prev = temp;
        }
        size++;
    }
    public void addLast(E e) {
        if (this.size==0){
            DNode temp = new DNode();
            temp.element = e;
            head = temp;
            tail = temp;
        } else {
            DNode temp = tail;
            temp.next = new DNode();
            temp.next.element = e;
            tail = temp.next;
            tail.prev = temp;
        }
        size++;
    }

    public E removeFirst() {
        if(this.size==0) {
            throw new NoSuchElementException("You can't remove an element from an empty list.");
        }
        else if(this.getSize()==1) {
            E e = head.element;
            head.element = null;
            head.next = null;
            tail.element = null;
            tail.prev = null;
            size--;
            return e;
        }
        E e = head.element;
        head = head.next;
;        head.prev.next = null;
        head.prev = null;
        size--;
        return e;
    }

    public E remove() {
        if(this.size==0) {
            throw new NoSuchElementException("You can't remove an element from an empty list.");
        }
        DNode temp = tail;
        if (this.size == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next.prev = null;
            tail.next = null;
        }

        size--;
        return temp.element;
    }

    public E removeLast() {
        if(this.size==0) {
            throw new NoSuchElementException("You can't remove an element from an empty list.");
        }
        DNode temp = tail;
        if (this.size == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next.prev = null;
            tail.next = null;
        }

        size--;
        return temp.element;
    }

    public E peekFirst() {
        if (this.size==0) {
            throw new NoSuchElementException("You can't remove an element from an empty list.");
        }
        return head.element;
    }

    public E peekLast() {
        if (this.size==0) {
            throw new NoSuchElementException("You can't remove an element from an empty list.");
        }
        return tail.element;
    }

    public boolean equals(Object o) {
        if(o instanceof MyDoublyLinkedList) {
            DNode temp = this.head;
            for (E e : (MyDoublyLinkedList<E>) o) {
                if (!e.equals(temp.element)) {
                    return false;
                } else {
                    temp = temp.next;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    /*
     * ADD YOUR CODE HERE
     */


    public Iterator<E> iterator() {
        return new DLLIterator();
    }

    private class DNode {
        private E element;
        private DNode next;
        private DNode prev;
    }

    private class DLLIterator implements Iterator<E> {
        DNode curr;

        public DLLIterator() {
            this.curr = head;
        }

        public boolean hasNext() {
            return this.curr != null;
        }

        public E next() {
            if (!this.hasNext())
                throw new NoSuchElementException();

            E element = this.curr.element;
            this.curr = this.curr.next;
            return element;
        }
    }
}
