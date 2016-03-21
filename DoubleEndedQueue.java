package algorithms;
//commentaar toevoegen bij elke methode
//zodat voor de buitenstaanders duidelijk wordt wat er in de methode plaatsvindt
public class DoubleEndedQueue<T> {

    private LinkedNode<T> head;
    private LinkedNode<T> tail;
    private int size = 0;

    public DoubleEndedQueue() {
        head = null;
        tail = null;
    }
    
    /**
     * Adds an element to the front of the linked list. 
     * @param node
     */

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
    
    /**
     * Adds an element to the back of the linked list. 
     * @param node
     */

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
    
    /**
     * Removes an element at the back of the linked list. 
     */

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
    
    /**
     * Removes an element at the front of the linked list. 
     */

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
    
    /**
     * Returns the head of the linked list if there is a head. 
     * @return head 
     */

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
    
    /**
     * Prints the linked list/queue.
     */

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
