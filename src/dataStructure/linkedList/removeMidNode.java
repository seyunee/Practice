package dataStructure.linkedList;

public class removeMidNode {
    public static void main(String[] args){
        LinkedList ll = new LinkedList();
        ll.append(2);
        ll.append(3);
        ll.append(5);
        ll.append(1);
        ll.append(1);
        ll.retrieve();

        deleteNode(ll.get(2));
        ll.retrieve();
    }

    private static boolean deleteNode(LinkedList.Node n){
        if(n == null || n.next==null){
            return false;
        }
        LinkedList.Node next = n.next;
        n.data = next.data;
        n.next = next.next;
        return true;
    }
}
