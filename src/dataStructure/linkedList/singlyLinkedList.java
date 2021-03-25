package dataStructure.linkedList;

public class singlyLinkedList {
    public static void main(String[] args){
        LinkedList ll = new LinkedList();
        ll.append(2);
        ll.append(3);
        ll.append(5);
        ll.append(1);
        ll.append(1);
        ll.retrieve();
        ll.delete(1);
        ll.retrieve();

    }
}
