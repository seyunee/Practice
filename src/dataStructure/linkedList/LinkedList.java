package dataStructure.linkedList;

public class LinkedList {
    Node header;

    static class Node {
        int data;
        Node next = null;
    }

    LinkedList(){
        header = new Node();
    }

    void append(int d){
        Node end = new Node();
        end.data = d;
        Node n = header;
        while (n.next != null){
            n = n.next;
        }
        n.next=end;
    }

    void delete(int d){
        Node n = header;
        while(n.next != null){
            if(n.next.data==d){
                n.next = n.next.next;
            }else{
                n = n.next;
            }
        }
    }

    void retrieve(){
        Node n = header.next;
        while(n.next!=null){
            System.out.print(n.data +" -> ");
            n = n.next;
        }

        System.out.println(n.data);
    }

    void removeDups(){
        Node n = header;
        while(n != null && n.next != null) {
            Node r = n;
            while(r.next != null){
                if(n.data == r.next.data){
                    r.next = r.next.next;
                }else{
                    r = r.next;
                }
            }
            n = n.next;
        }
    }

    Node getFirtst(){
        return header.next;
    }

    Node get(int n){
        Node nthNode = header.next;
        int i=1;
        while (i<n){
            nthNode = nthNode.next;
            i++;
        }
        return nthNode;
    }
}
