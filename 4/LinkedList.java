public class LinkedList{
    public Node head;
    
    public LinkedList(Object [] a){
        head= new Node(a[0],null);
        Node tail=head;
        for(int i=1;i<a.length;i++){
            Node n=new Node(a[i],null);
            tail.next=n;
            tail=n;
        }
    }
    
    public LinkedList(Node h){
        head = h;
    }
    
    public int countNode(){
        int count=0;
        for(Node n=head;n!=null ;n=n.next ){
            count++;
        }
        return count;
    }
    
    public void printList(){
        for(Node n=head;n!=null;n=n.next ){
            System.out.printf("%d ", n.element);
        }
        System.out.println();
    }
    
    public Node nodeAt(int idx){
        if(idx>=0 && idx<countNode()){
            int i=0;
            Node n=head;
            for(  ;  i<idx  ;i++,n=n.next){
                
            }
            return n;    
        }
        return null;
    }
    
    public Object get(int idx){
        Node n=nodeAt(idx);
        if(n!=null)
            return n.element;
        return null;
    }
    
    public Object set(int idx, Object elem){
        Node n=nodeAt(idx);
        Object e=null;
        if(n!=null){
            e=n.element;
            n.element=elem;
        }else{
            n = new Node(elem, null);
        }
        return e;
    }
    
    public int indexOf(Object elem){
        int i=0;
        for(Node n=head;n!=null;n=n.next){
            if(n.element.equals(elem))
                return i;
            else 
                i++;
        }
        return -1;
    }
    
    public boolean contains(Object elem){
        for(Node n=head;n!=null;n=n.next){
            if(n.element.equals(elem))
                return true;
        }
        return false;
    }
    
    public Node copyList(){
        Node newHead = null, newTail = null;
        for(Node n=head;n!=null;n=n.next){
            Node newNode = new Node(n.element, null);
            if(newHead == null){
                newHead = newNode; newTail = newNode;
            } else {
                newTail.next = newNode; newTail = newNode;
            }
        }
        return newHead;
    }
    
    public Node reverseList(){
        Node newHead = null;
        for(Node n=head;n!=null;n=n.next){
            Node newNode = new Node(n.element, null);
            if(newHead == null){
                newHead = newNode;
            } else {
                newNode.next = newHead; newHead = newNode;
            }
        }
        return newHead;
    }
    
    public void insert(Object elem, int idx){
        if(idx>=0){
            Node newNode = new Node(elem, null);
            if(idx == 0){
                newNode.next = head;
                head = newNode;
            } else {
                Node prevNode = nodeAt(idx-1);
                newNode.next = prevNode.next;
                prevNode.next = newNode;
            }
        } else {
            System.err.println("Invalid Index.");
        }
    }
    
    public Object remove(int index){
        if(index>=0 && index<countNode()){
            Node temp;
            if(index == 0){
                temp = head;
                head = head.next;
                return temp.element;
            } else {
                Node prevNode = nodeAt(index-1);
                temp = prevNode.next;
                prevNode.next = temp.next;
                return temp.element;
            }
        } else {
            return null;
        }
    }
    
    public void rotateLeft(){
        int a = countNode();
        Node lastNode = nodeAt(a-1);
        lastNode.next = head;
        head = head.next;
        lastNode.next.next = null;
    }
    
    public void rotateRight(){
        int a = countNode();
        Node slastNode = nodeAt(a-2);
        //Node newHead = slastNode.next;
        slastNode.next.next = head;
        head = slastNode.next;
        slastNode.next = null;
    }
}