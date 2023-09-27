class A3{
    public static void main(String[] str){
        int q[] = {1, 1, 2, 9, 2, 22};
        int w[] = {2, 4, 5, 7, 222, 2222, 2222222, 212222222};
        Node a = A.createclist(q);
        Node b = A.createclist(w);
System.out.println(A.evenSum(a));
//        Node c = A.mergeList(a, b);
//        for(Node n = c; n!=null; n=n.next){
//            System.out.println(n.e);
//        }
    }
}
class Node {
    public Object e;
    public Node next;
    public Node (Object e, Node n){
        this.e = e; next = n;
    }
}
class A{
    static Node head;
    static Node createlist(int[] array){//singly linked list...
        Node newN = new Node(array[0], null);
        head = newN;
        for(int i = 1; i < array.length; i++){
            Node temp = new Node(array[i], null);
            newN.next = temp;
            newN = temp;
        }
        return head;
    }
    
    static Node createclist(int[] array){//singly circular linked list
        Node newN = new Node(array[0], null);
        head = newN;
        for(int i = 1; i < array.length; i++){
            Node temp = new Node(array[i], null);
            newN.next = temp;
            newN = temp;
        }
        newN.next = head;
        return head;
    }
    
    static Node createdclist(int[] array){//singly dummy headed circular linked list
        Node newN = new Node("Dummy", null);
        head = newN;
        for(int i = 0; i < array.length; i++){
            Node temp = new Node(array[i], null);
            newN.next = temp;
            newN = temp;
        }
        newN.next = head;
        return head;
    }
    
    public static void reverseList (Node h){//for circular
        Node nhead = new Node(h.e, null);
        Node ntail = nhead;
        for(Node n = h.next; n!=head; n=n.next){
            Node newN = new Node(n.e, nhead);
            nhead = newN;
        }
        ntail.next = nhead;
        head = nhead;
    }
    
    static void removeDuplicates (Node head){
        for(Node n = head; n!=null; n=n.next){
            for(Node a = n; a.next!=null; ){
                if(n.e == a.next.e){
                    a.next = a.next.next;
                } else {
                    a=a.next;
                }
            }
        }
    }
    
    public static boolean search(Node head, Object elem){
        for(Node n = head; n!=null; n=n.next){
            if(n.e==elem){
                return true;
            }
        }
        return false;
    }
    
    public static int evenSum (Node head){//for circular
        int sum = 0;
        if(Integer.parseInt(head.e+"")%2==0){
            sum += Integer.parseInt(head.e+"");
        }
        for(Node n = head.next; n!=head; n=n.next){
            if(Integer.parseInt(n.e+"")%2==0){
                sum += Integer.parseInt(n.e+"");
            }
        }
        return sum;
    }
    
    public static Node mergeList (Node head1, Node head2){
        Node dummy = new Node(null, null);
        Node tail = dummy;
        while(true){
            if(head1.next == null){
                tail.next = head2.next;
                break;
            }
            if(head2.next == null){
                tail.next = head1.next;
                break;
            }
            if(Integer.parseInt(head1.next.e+"") <= Integer.parseInt(head2.next.e+"")){
                tail.next = new Node(head1.next.e, null);
                head1 = head1.next;
            } else {
                tail.next = new Node(head2.next.e, null);
                head2 = head2.next;
            }
            tail = tail.next;
        }
        return dummy;
    }
}