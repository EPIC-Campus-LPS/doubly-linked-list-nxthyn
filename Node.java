/**********
 * 
 * @author Nathan Hoehndorf
 * @since October 26, 2023
 * @version 1.0
 * 
***********/
public class Node<E> {

    /**
     * 
     * The value held by each node
     * 
     */
    private E value;
    /**
     * 
     * next -- the next object that the node points to
     * previous -- the previous object that the node points to
     * 
     */
    private Node<E> next, previous;

    /**
     * 
     * default no-argument constructor
     * 
     */
    public Node() {

        value = null;
        next = null;
        previous = null;

    }

    /**
     * 
     * constructor that allows an element to be passed into the value field
     * @param element
     * 
     */
    public Node(E element) {

        value = element;
        next = null;
        previous = null;

    }

    /**
     * 
     * returns the value stores by the node
     * @return value
     */
    public E getNodeValue() {

        return value;

    }

    /**
     * 
     * returns the reference to the next node
     * @return next
     * 
     */
    public Node<E> getNextNode() {

        return next;

    }

    /**
     * 
     * retursn the reference to the previous node
     * @return previous
     * 
     */
    public Node<E> getPreviousNode() {

        return previous;

    }

    /**
     * Sets the value held by the node
     * 
     * @param val
     * 
     */
    public void setNodeValue(E val) {

        value = val;

    }

    /**
     * 
     * changes the reference to the next node
     * @param n
     * 
     */
    public void setNextNode(Node<E> n) {

        next = n;

    }

    /**
     * 
     * changes the reference to the previous node
     * @param n
     */
    public void setPreviousNode(Node<E> n) {

        previous = n;

    }


}
