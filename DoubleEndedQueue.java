package algorithms;

public class DoubleEndedQueue<T> {

    private LinkedNode<T> head;
    private LinkedNode<T> tail;
    private int size = 0;

    public DoubleEndedQueue() {
        head = null;
        tail = null;
    }

    public void addElementToFront(T node) {
        LinkedNode<T> newNode = new LinkedNode<T>(node);
        if (head != null) {
            newNode.setNext(head);
            head.setPrevious(newNode);
        }
        head = newNode;
        if (tail == null) {
            tail = head;
        }
        size++;
    }

    public void addElementToBack(T node) {
        LinkedNode<T> newNode = new LinkedNode<T>(node);
        if (tail != null) {
            newNode.setPrevious(tail);
            tail.setNext(newNode);
        }
        tail = newNode;
        if (head == null) {
            head = tail;
        }
        size++;
    }

    public void removeBack() {
        if (!isEmpty()) {
            LinkedNode<T> oldLast = tail;
            tail = oldLast.getPrevious();
            if (tail == null) {
                head = null;
            } else {
                tail.setNext(null);
            }
            size--;
        }
    }

    public void clear() {
        head = null;
        tail = null;
    }

    public void removeFront() {
        if (!isEmpty()) {
            head = head.getNext();
            if (head == null) {
                tail = null;
            } else {
                head.setPrevious(null);
            }
            size--;
        }
    }

    public T getHead() {
        if (head != null) {
            return head.getCurrent();
        } else {
            return null;
        }

    }

    public T getTail() {
        if (tail != null) {
            return tail.getCurrent();
        } else {
            return null;
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return ((head == null) && (tail == null));
    }

    public void printList() {
        if (head != null) {
            LinkedNode<T> root = head;
            System.out.print("Queue: " + root.getCurrent().toString() + " ");
            while (root.getNext() != null) {
                root = root.getNext();
                System.out.print(root.getCurrent().toString() + " ");
            }
            System.out.println();
        } else {
            System.out.println("Queue empty");
        }
    }

}
