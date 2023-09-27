import static java.lang.System.*;
class CircularList{
    Node head;
    
    public void buildFromArray(int[] cir,int st,int size){
        head = new Node(cir[st], null);
        Node tail = head;
        int a = (st+1)%cir.length;
        for(int i = 1; i < size; i++){
            Node n = new Node(cir[a], null);
            tail.next = n;
            tail = n;
            a = (a+1)%cir.length;
        }
        tail.next = head;
    }
    
    public void print(){
        out.printf("%d ",head.element);
        for(Node n = head.next; n!=head; n=n.next){
            out.printf("%d ",n.element);
        }
        out.println();
    }
    
    public void buildReverse(){
        Node tail = new Node(head.element, null);
        Node tempHead = tail;
        for(Node n = head.next; n!=head; n=n.next){
            Node newNode = new Node(n.element, null);
            newNode.next = tempHead;
            tempHead = newNode;
        }
        tail.next = tempHead;
        head = tempHead;
    }
    
    public void addElement(int element, int index){
        Node temp = new Node(element, null);
        if(index == 0){
            Node n;
            for(n = head.next; n.next!=head; n=n.next){
            }
            temp.next = head;
            n.next = temp;
            head = temp;
        } else {
            int count = 0;
            Node n;
            for(n = head; n.next!=head; n=n.next){
                if(count==(index-1)){
                    break;
                }
                count++;
            }
            temp.next = n.next;
            n.next = temp;
        }
    }
    
    public void deleteElement(int index){
        if(index == 0){
            Node n;
            for(n = head.next; n.next!=head; n=n.next){
            }
            n.next = head.next;
            head = head.next;
        } else {
            int count = 0;
            Node n;
            for(n = head; n.next!=head; n=n.next){
                if(count==(index-1)){
                    break;
                }
                count++;
            }
            n.next = n.next.next;
        }
    }
}