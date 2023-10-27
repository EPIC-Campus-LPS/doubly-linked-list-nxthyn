public class DoublyLinkedListTest {

    public static void main(String[] args) {

        //DoublyLinkedList list = new DoublyLinkedList(new Node<Integer>(1), new Node<Integer>(2));
        DoublyLinkedList list = new DoublyLinkedList();

        list.add(1);
        list.add(2);
  

        System.out.println(list.size());
        System.out.println(list);

        list.remove(0);

        System.out.println("Size: " + list.size());
        System.out.println(list);

    }

}
