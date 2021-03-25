package dataStructure.linkedList;

public class kthNode {
    public static void main(String[] args){
        LinkedList ll = new LinkedList();
        ll.append(2);
        ll.append(3);
        ll.append(5);
        ll.append(1);
        ll.append(1);
        ll.retrieve();

        int k =4;
        Reference r = new Reference();
        LinkedList.Node found = KthToLast(ll.getFirtst(), k, r);
        System.out.println(found.data);
    }

    static class Reference{
        public int count = 0 ;
    }
    private static LinkedList.Node KthToLast(LinkedList.Node n, int k, Reference r){
        if (n == null) {
            return null;
        }

        LinkedList.Node found = KthToLast(n.next, k, r);
        r.count++;
        if(r.count == k){
           return n;
        }
        return found;
    }
}
