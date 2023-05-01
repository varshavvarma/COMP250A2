package assignment2;

public abstract class MyLinkedList<E> implements MyList<E> {
    protected int size;

    public int getSize() {
        return size;
    }
    public boolean isEmpty() {
        if (this.size==0)
            return true;
        return false;
    }
}
