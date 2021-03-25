package dataStructure.linkedList;

public class removeDups {
    public static void main(String[] args){
        LinkedList ll = new LinkedList();
        ll.append(1);
        ll.append(2);
        ll.append(3);
        ll.append(5);
        ll.append(4);
        ll.append(3);
        ll.append(5);
        ll.append(1);
        ll.append(1);
        ll.retrieve();
        ll.removeDups();
        ll.retrieve();

    }
}
