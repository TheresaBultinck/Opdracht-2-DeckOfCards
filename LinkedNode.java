package algorithms;


public class LinkedNode<T> {

    private LinkedNode<T> next;
    private LinkedNode<T> previous;
    private T current;

    /**
     *
     * @param current
     * @param next
     * @param previous
     */
    public LinkedNode(T current, LinkedNode<T> next, LinkedNode<T> previous) {
        this.current = current;
        this.previous = previous;
        this.next = next;
    }

    /**
     *
     * @param current
     */
    public LinkedNode(T current) {
        this.current = current;
        this.previous = null;
        this.next = null;
    }

    public LinkedNode<T> getNext() {
        return next;
    }

    public LinkedNode<T> getPrevious() {
        return previous;
    }

    public T getCurrent() {
        return current;
    }

    public void setNext(LinkedNode<T> next) {
        this.next = next;
    }

    public void setPrevious(LinkedNode<T> previous) {
        this.previous = previous;
    }

}