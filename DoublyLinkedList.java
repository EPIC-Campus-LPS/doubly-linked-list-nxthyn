/**********
 * 
 * @author Nathan Hoehndorf
 * @since October 26, 2023
 * @version 1.0
 * 
 **********/
public class DoublyLinkedList<E> {

    /**
     * 
     * the very first node of the LinkedList
     * 
     */
    private static Node head;
    /**
     * 
     * the very last node of the LinkedList (assuming size > 1)
     * 
     */
    private static Node tail;

    /**
     * 
     * length of LinkedList
     * 
     */
    public static int size;

    /**
     * 
     * default no-argument constructor
     * 
     */
    public DoublyLinkedList() {

        head = null;
        tail = null;
        size = 0;

    }

    /**
     * 
     * adds a node containing element to the end of the LinkedList
     * @param element
     * 
     */
    public void add(E element) {

        if (size == 0) { // if LinkedList is empty

            head = new Node<E>(element); // sets head as new node
            size++; // increments size
            return; // exits method

        } else if (size == 1) { // if there is only a head

            head.setNextNode(new Node<E>(element)); // creates both a reference and adds its value
            tail = head.getNextNode(); // sets tail to the newly created node
            head.setNextNode(tail); // points head to tail
            tail.setPreviousNode(head); // points tail back to head
            size++; // increments size
            return; // exits method

        }

        Node<E> temp = tail; // saves the reference of tail
        tail.setNextNode(new Node<E>(element)); // creates new node after end
        tail = tail.getNextNode(); // sets new node to the tail
        tail.setPreviousNode(temp); // points new tail back to previously "tailed" node
        size++; // increments size

    }

    /**
     * 
     * adds a new node at a specified index of the LinkedList
     * @param index
     * @param element
     * 
     */
    public void add(int index, E element) {


        try { // in the case that index is not out of bounds

            if (size == 0 && index == 0) { // index is valid, but empty list

                // same as size == 0 case in add(E element) method

                head = new Node<E>(element);
                size++;
                return;

            } else if (size == 1) { // requires two cases

                if (index == 0) { // first element

                    tail = head; // moves head to tail
                    head = new Node<E>(element); // creates new reference for head
                    head.setNextNode(tail); // connects head to tail
                    tail.setPreviousNode(head); // connects tail to head
                    size++; // increments size
                    return; // exits method

                } else if (index == 1) { // last element

                    tail = new Node<E>(element); // creates new node and assigns it to tail
                    head.setNextNode(tail); // points head to tail
                    tail.setPreviousNode(head); // points tail to head
                    size++; // increments size
                    return; // exits method

                }

            }

            if (index == size) { // if last index+1 is chosen

                Node<E> temp = tail; // stores the tail reference
                tail.setNextNode(new Node<E>(element)); // creates new node after tail
                tail = tail.getNextNode(); // sets tail to the new node
                tail.setPreviousNode(temp); // points tail back to what was previously the tail
                size++; // increments size
                return; // exits method

            }

            if (index == 0) {

                Node temp = head;
                head = new Node(element);
                head.setNextNode(temp);
                size++;
                return;

            }

            Node<E> counter = head;
            for (int i = 0; i < index - 1; i++) { // gets a node equal to the one before the passed index

                counter = counter.getNextNode();

            }

            Node<E> temp1 = counter.getNextNode(); // holds node at passed index
            counter.setNextNode(new Node(element)); // makes a new node at index
            Node<E> temp = counter.getNextNode(); // creates reference to newly created node
            temp.setPreviousNode(counter); // points new node back to previous node
            temp.setNextNode(temp1); // points new node to next node
            size++; // increments size
        } catch (NullPointerException E) { // in the case index is out of bounds

            throw new IndexOutOfBoundsException("LinkedListOutOfBoundsException");

        }


    }

    /**
     * 
     * removes the node at the given index and returns its value
     * @param index
     * @return value
     * 
     */
    public E remove(int index) {

        try { // in the case that index is in bounds

            if (size == 1) { // if the array only has one element

                E temp = (E) head.getNodeValue(); // holds the value of the node
                head = null; // dereferences the node
                size--; // decrements size
                return temp; // returns saved value

            }

            if (index == 0) { // if the head node is called

                E temp1 = (E) head.getNodeValue(); // saves head node value
                Node temp = head.getNextNode().getNextNode(); // saves third element
                head = head.getNextNode(); // moves the head up one
                head.setNextNode(temp); // points head to new second node
                size--; // decrements size
                return temp1; // returns saved value

            }

            Node<E> counter = head; // starts at first index
            Node<E> result; // will eventually be returned

            for (int i = 0; i < index-1; i++) { // counts up to index-1

                counter = counter.getNextNode();

            }

            result = counter.getNextNode(); // sets result to the node at index
            Node<E> temp = counter.getNextNode().getNextNode(); // saves reference to node 2 after index
            counter.setNextNode(temp); // moves rest of LinkedList back 1
            size--; // decrements size
            return result.getNodeValue(); // returns value held in node

        } catch (NullPointerException e) { // in the case that Linked List is empty or index is out of bounds

            if (size == 0) throw new NullPointerException("EmptyLinkedListException");
            else throw new IndexOutOfBoundsException();

        }


    }

    /**
     * removes the final node in the LinkedList and returns its value
     * @return value
     * 
     */
    public E remove() {

        try { // if the LinkedList isn't empty

            if (size == 1) { // if there is only one node

                E temp = (E) head.getNodeValue(); // saves value
                head = null; // dereferences node
                size--; // decrements size
                return temp; // returns saved value

            }

            E temp1 = (E) tail.getNodeValue(); // saves tail value
            Node<E> prev = tail.getPreviousNode(); // saves reference to second to last node
            Node<E> temp = prev.getPreviousNode(); // saves second-to-last node
            tail = prev; // moves tail back one node
            tail.setNextNode(null); // makes tail final node
            tail.setPreviousNode(temp); // points tail to previous node
            size--; // decrements size
            return (E) temp1; // returns saved value

        } catch (NullPointerException E) { // when LinkedList is empty

            throw new IndexOutOfBoundsException("EmptyLinkedListException");

        }

    }

    /**
     * 
     * replaces the value of a node at the given index
     * @param index
     * @param element
     * 
     */
    public E set(int index, E element) {

        try { // if index is in bounds
            if (size == 0) { // if LinkedList is empty

                throw new IndexOutOfBoundsException("Empty LinkedList");

            }

            if (index == 0) { // if the head tail is called

                E temp = (E) head.getNodeValue();
                head.setNodeValue(element);
                return temp;

            }

            Node counter = head; // start counting at first node
            for (int i = 0; i < index; i++) { // go to given index

                counter = counter.getNextNode();

            }
            E tempVal = (E) counter.getNodeValue();
            counter.setNodeValue(element); // replaces value with new element
            return tempVal;

        } catch (Exception e) { // if index is out of bounds

            throw new IndexOutOfBoundsException();

        }

    }

    /**
     * 
     * toString method for a LinkedList
     * 
     */
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

    /**
     * returns the size of the LinkedList
     * @return size
     * 
     */
    public static int size() {

        return size;

    }

}
