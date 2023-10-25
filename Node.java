public class Node<E> {

    private E value;
    private Node<E> next, previous;

    public Node() {

        value = null;
        next = null;
        previous = null;

    }

    public Node(E val) {

        value = val;

    }

    public Node(E val, Node<E> n) {

        value = val;
        next = n;

    }

    public E getNodeValue() {

        return value;

    }

    public Node<E> getNextNode() {

        return next;

    }

    public Node<E> getPreviousNode() {

        return previous;

    }

    public void setNodeValue(E val) {

        value = val;

    }

    public void setNextNode(Node<E> n) {

        next = n;

    }

    public void setPreviousNode(Node<E> n) {

        previous = n;

    }


}
