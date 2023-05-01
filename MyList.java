package assignment2;
import java.util.Iterator;
import java.util.NoSuchElementException;

public interface MyList<E> extends Iterable<E> {
    public abstract int getSize();

    public abstract boolean isEmpty();

    public abstract void add(E e);

    public abstract void clear();

    public abstract E remove();
}
