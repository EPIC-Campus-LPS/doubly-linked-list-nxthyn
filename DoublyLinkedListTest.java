import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {

    @org.junit.jupiter.api.Test
    void add() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals("[1, 2, 3]",list.toString());
    }

    @org.junit.jupiter.api.Test
    void testAdd() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.add(0,1);
        list.add(0,2);
        list.add(0,3);
        assertEquals("[3, 2, 1]", list.toString());
    }

    @org.junit.jupiter.api.Test
    void remove() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.remove();
        assertEquals("[1, 2, 3]", list.toString());
    }

    @org.junit.jupiter.api.Test
    void testRemove() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.remove(2);
        assertEquals("[1, 2, 4]", list.toString());
    }

    @org.junit.jupiter.api.Test
    void set() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.set(0,2);
        assertEquals("[2, 2, 3]", list.toString());
    }
}