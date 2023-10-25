public class DoublyLinkedList<E> {

    private static Node head;
    private static Node tail;

    public static int size;

    public DoublyLinkedList() {

        head = null;
        tail = null;
        size = 0;

    }

    public void add(E element) {

        if (size == 0) {

            head = new Node<E>(element);
            //tail = null;
            size++;
            return;

        } else if (size == 1) {

            head.setNextNode(new Node<E>(element));
            tail = head.getNextNode();
            head.setNextNode(tail);
            tail.setPreviousNode(head);
            size++;
            return;

        }

        Node<E> temp = tail;
        tail.setNextNode(new Node<E>(element));
        tail = tail.getNextNode();
        tail.setPreviousNode(temp);
        size++;

    }

    public void add(int index, E element) {


        try {

            if (size == 0 && index == 0) {

                head = new Node<E>(element);
                ///tail = null;
                size++;
                return;

            } else if (size == 1) {

                if (index == 0) {

                    tail = head;
                    head = new Node<E>(element);
                    head.setNextNode(tail);
                    tail.setPreviousNode(head);
                    size++;
                    return;

                } else if (index == 1) {

                    tail = new Node<E>(element);
                    head.setNextNode(tail);
                    tail.setPreviousNode(head);
                    size++;
                    return;

                }

            }

            if (index == size) {

                Node<E> temp = tail;
                tail.setNextNode(new Node<E>(element));
                tail = tail.getNextNode();
                tail.setPreviousNode(temp);
                size++;
                return;

            }

            Node<E> counter = head;
            for (int i = 0; i < index - 1; i++) {

                counter = counter.getNextNode();

            }
            Node<E> temp1 = counter.getNextNode();
            counter.setNextNode(new Node(element));
            Node<E> temp = counter.getNextNode();
            temp.setPreviousNode(counter);
            temp.setNextNode(temp1);
            size++;
        } catch (NullPointerException E) {

            throw new IndexOutOfBoundsException("LinkedListOutOfBoundsException");

        }


    }

    public E remove(int index) {

        try {

            if (size == 1) {

                E temp = (E) head.getNodeValue();
                head = null;
                size--;
                return temp;

            }

            if (index == 0) {

                E temp1 = (E) head.getNodeValue();
                Node temp = head.getNextNode().getNextNode();
                head = head.getNextNode();
                head.setNextNode(temp);
                size--;
                return temp1;

            }

            Node<E> counter = head;
            Node<E> result;

            for (int i = 0; i < index-1; i++) {

                counter = counter.getNextNode();

            }
            result = counter.getNextNode();
            Node<E> temp = counter.getNextNode().getNextNode();
            counter.setNextNode(temp);
            size--;
            return result.getNodeValue();

        } catch (NullPointerException e) {

            throw new IndexOutOfBoundsException("ËmptyLinkedListException");

        }


    }

    public E remove() {
        try {

            if (size == 1) {

                E temp = (E) head.getNodeValue();
                head = null;
                size--;
                return temp;

            }

            E temp1 = (E) tail.getNodeValue();
            Node<E> prev = tail.getPreviousNode(); //here
            Node<E> temp = prev.getPreviousNode();
            tail = prev;
            tail.setNextNode(null);
            tail.setPreviousNode(temp);
            size--;
            return (E) temp1;

        } catch (NullPointerException E) {

            throw new IndexOutOfBoundsException("EmptyLinkedListException");

        }

    }

    public void set(int index, E element) {

        Node<E> counter = head;
        for (int i = 0; i < index-1; i++) {

            counter = counter.getNextNode();

        }

        counter.setNodeValue(element);

    }
    @Override
    public String toString() {

        if (size == 0) {

            return "[]";

        }

        if (size == 1) {

            return "[" + head.getNodeValue() + "]";

        }

        String result = "";
        result += "[";
        Node<E> temp = head;

        while (temp.getNextNode() != null) {

            result += temp.getNodeValue() + ", ";
            temp = temp.getNextNode();

        }

        result += temp.getNodeValue() + "]";

        return result;

    }

    public static int size() {

        return size;

    }

}
